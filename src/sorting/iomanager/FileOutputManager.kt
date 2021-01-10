package sorting.iomanager

import java.io.File

class FileOutputManager(outputFilename: String) : OutputManager {
    private val outputFile = File(outputFilename)
    override fun write(text: String) {
        outputFile.writeText(text)
    }

    override fun writeln(text: String) {
        this.write("$text\n")
    }

    override fun close() {}

}