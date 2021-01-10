package sorting.iomanager

import java.io.File
import java.util.*

class FileInputManager(inputFilename: String) : InputManager {
    private val inputFile = File(inputFilename)
    private val scanner = Scanner(inputFile)


    override fun read(): String {
        return scanner.next()!!
    }

    override fun readln(): String {
        return scanner.nextLine()

    }

    override fun hasNext(): Boolean {
        return scanner.hasNext()
    }

    override fun close() {
        scanner.close()
    }
}