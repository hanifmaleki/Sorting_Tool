package sorting.iomanager

interface InputManager {
    fun read(): String
    fun readln(): String
    fun hasNext(): Boolean
    fun close()
}