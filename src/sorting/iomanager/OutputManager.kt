package sorting.iomanager

interface OutputManager {
    fun write(text: String)
    fun writeln(text: String)
    fun close()
}