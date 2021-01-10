package sorting.iomanager

import java.util.*

class ConsoleInputManager : InputManager {
    private val scanner = Scanner(System.`in`)


    override fun read(): String = scanner.next()


    override fun readln(): String = scanner.nextLine()


    override fun hasNext() = scanner.hasNext()

    override fun close() {
        scanner.close()
    }
}