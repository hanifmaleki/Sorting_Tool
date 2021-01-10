package sorting.iomanager

class IoManager private constructor(private val inputManager: InputManager, private val outputManager: OutputManager) : InputManager, OutputManager {

    companion object {
        fun getIoManager(inputFileName: String?, outputFileName: String?): IoManager {
            val inputManager = if (inputFileName != null) FileInputManager(inputFileName) else ConsoleInputManager()
            val outputManager = if (outputFileName != null) FileOutputManager(outputFileName) else ConsoleOutputManager()
            return IoManager(inputManager, outputManager)
        }
    }

    override fun read() = inputManager.read()

    override fun readln() = inputManager.readln()

    override fun hasNext() = inputManager.hasNext()

    override fun write(text: String) {
        outputManager.write(text)
    }

    override fun writeln(text: String) {
        outputManager.writeln(text)
    }

    override fun close() {
        outputManager.close()
        inputManager.close()
    }
}