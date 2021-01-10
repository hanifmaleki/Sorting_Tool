package sorting.processor

import sorting.iomanager.IoManager

class LongDataTypeSorter(ioManager: IoManager) : DataTypeSorter<Long>(ioManager) {
    override fun readNext(): String = ioManager.read()

    override fun getMax() = "$max"

    override fun getInitializedMax() = Long.MIN_VALUE

    override fun getComparator() = naturalOrder<Long>()

    override fun getGreatestSentence() = "The greatest number"
    override fun getName() = "names"
    override fun getNaturalComparator() = naturalOrder<Long>()
    override fun isValid(arg: String) = arg.toLongOrNull() != null

    override fun getValid(arg: String) = arg.toLong()

    override fun getInvalidMessage(arg: String) = "$arg is not a long. It will be skipped."
}
