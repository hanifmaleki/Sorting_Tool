package sorting.processor

import sorting.iomanager.IoManager
import java.util.*
import kotlin.Comparator

class LineDataTypeSorter(ioManager: IoManager) : DataTypeSorter<String>(ioManager) {
    override fun readNext(): String = ioManager.readln()

    override fun getMax() = "\n$max\n"

    override fun getInitializedMax() = ""

    override fun getComparator() = Comparator<String> { s1, s2 -> s1.length.compareTo(s2.length) }

    override fun getGreatestSentence() = "The longest line"
    override fun getName() = "lines"
    override fun getNaturalComparator() = naturalOrder<String>()

    override fun getValid(arg: String) = arg

}