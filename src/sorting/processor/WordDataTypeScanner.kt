package sorting.processor

import sorting.iomanager.IoManager
import kotlin.Comparator

class WordDataTypeSorter(ioManager: IoManager) : DataTypeSorter<String>(ioManager) {
    override fun readNext(): String = ioManager.read()

    override fun getMax() = max

    override fun getInitializedMax() = ""

    override fun getComparator() = Comparator<String> { s1, s2 -> s1.length.compareTo(s2.length) }

    override fun getNaturalComparator() = naturalOrder<String>()
    override fun getName() = "words"
    override fun getGreatestSentence() = "The longest word"

    override fun getValid(arg: String) = arg

}