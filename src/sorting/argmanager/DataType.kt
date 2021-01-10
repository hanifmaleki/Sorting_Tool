package sorting.argmanager

enum class DataType(val type: String) {
    LONG_DATA_TYPE("long"),
    LINE_DATA_TYPE("line"),
    WORD_DATA_TYPE("word");

    companion object {
        fun findByType(type: String): DataType {
            for (enum in values()) {
                if (type == enum.type) return enum
            }
            throw RuntimeException("Wrong data type!")
        }
    }
}