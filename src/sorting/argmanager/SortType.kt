package sorting.argmanager

enum class SortingType(val type: String) {
    NATURAL("natural"),
    BY_COUNT("byCount");

    companion object {

        fun findByType(type: String): SortingType {
            for (enum in values()) {
                if (type == enum.type) return enum
            }
            throw RuntimeException("Wrong sorting type!")
        }

    }
}