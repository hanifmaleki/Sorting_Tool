package sorting.processor

import sorting.argmanager.DataType
import sorting.argmanager.SortingType
import sorting.iomanager.IoManager
import java.util.*
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.Comparator
import kotlin.streams.asSequence
import kotlin.streams.toList

abstract class DataTypeSorter<E>(val ioManager: IoManager) {
    open var max = this.getInitializedMax()

    abstract fun readNext(): String
    abstract fun getMax(): String
    open fun isValid(arg: String) = true
    abstract fun getValid(arg: String): E
    open fun getInvalidMessage(arg: String) = ""

    abstract fun getInitializedMax(): E
    abstract fun getComparator(): Comparator<E>
    abstract fun getNaturalComparator(): Comparator<E>
    abstract fun getGreatestSentence(): String
    abstract fun getName(): String

    companion object {
        fun getDataType(type: DataType, ioManager: IoManager) = when (type) {
            DataType.LONG_DATA_TYPE -> LongDataTypeSorter(ioManager)
            DataType.LINE_DATA_TYPE -> LineDataTypeSorter(ioManager)
            DataType.WORD_DATA_TYPE -> WordDataTypeSorter(ioManager)
        }
    }

    fun getMaxAndCount() {
        val input = readInputAsStream().filter { isValid(it) }.map { getValid(it) }.toList()
        val count = input.size
        val max = input.maxWithOrNull(getComparator())!!
        val times = input.count { it == max }

        val percent = (times.toDouble() / count.toDouble() * 100).toInt()
        ioManager.writeln("Total numbers: $count.")
        ioManager.writeln("${getGreatestSentence()}: ${getMax()} ($times time(s), $percent%).")

    }

    fun sort(sortingType: SortingType) {
        val pair = readInputAsStream().asSequence().partition { !isValid(it) }
        pair.first.forEach { ioManager.writeln(getInvalidMessage(it)) }
        val list = pair.second.map { getValid(it) }.toList()
        if (sortingType == SortingType.BY_COUNT) {
            sortByCount(list)
        } else {
            sortNatural(list)
        }
        ioManager.close()
    }

    private fun sortByCount(input: List<E>) {
        val count = input.size
        val comparator: Comparator<Pair<E, Int>> =
            Comparator<Pair<E, Int>> { p1, p2 -> p1.second.compareTo(p2.second) }
                .thenComparator { p1, p2 -> getNaturalComparator().compare(p1.first, p2.first) }
        val list = input.groupBy { it }.map { (key, value) -> Pair(key, value.size) }.sortedWith(comparator)
        ioManager.writeln("Total numbers: ${count}.")
        list.forEach {
            val itemCount = it.second
            val percent = (100.0 * itemCount.toDouble() / count.toDouble()).toInt()
            ioManager.writeln("${it.first}: $itemCount time(s), ${percent}%")
        }
    }

    private fun sortNatural(list: List<E>) {
        Collections.sort(list, getNaturalComparator())
        ioManager.writeln("total ${getName()}: ${list.size}")
        ioManager.writeln("Sorted data: ${list.joinToString(separator = " ")}")
    }


    private fun readInputAsStream(): Stream<String> {
        val iterator: Iterator<String> = object : Iterator<String> {
            override fun hasNext() = ioManager.hasNext()
            override fun next() = readNext()
        }
        return StreamSupport.stream(
            Spliterators.spliteratorUnknownSize(
                iterator,
                Spliterator.ORDERED or Spliterator.IMMUTABLE
            ), false
        )
    }

}







