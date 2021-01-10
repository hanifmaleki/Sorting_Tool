package sorting.iomanager

class ConsoleOutputManager : OutputManager {
    override fun write(text: String) {
        print(text)
    }

    override fun writeln(text: String) {
        println(text)
    }

    override fun close() {}
}