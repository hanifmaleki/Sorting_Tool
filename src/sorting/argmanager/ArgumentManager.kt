package sorting.argmanager

import sorting.iomanager.IoManager
import sorting.processor.DataTypeSorter

abstract class ArgumentManager {
    abstract fun perform()

    companion object {
        private const val dataTypeArgument = "-dataType"
        private const val sortingTypeArgument = "-sortingType"
        private const val inputFileArgument = "-inputFile"
        private const val outputFileArgument = "-outputFile"


        private val allowedParameters = listOf(dataTypeArgument, sortingTypeArgument, inputFileArgument, outputFileArgument)
        private val mandatoryParameters = listOf<String>()


        fun getCommand(args: Array<String>): ArgumentManager? {
            mandatoryParameters
                .filter { !args.contains(it) }
                .forEach { println("$it is mandatory argument but does not exist.") }
            if (mandatoryParameters.any { !args.contains(it) }) {
                return null
            }
            var index = 0
            var dataType: DataType = DataType.LINE_DATA_TYPE
            var sortingType: SortingType = SortingType.NATURAL
            var inputFileName: String? = null
            var outputFileName: String? = null
            while (index < args.size) {
                val command = args[index]
                if (!allowedParameters.contains(command)) {
                    println("$command is not a valid parameter. It will be skipped.")
                    index++
                    continue
                }
                if (index + 1 == args.size) {
                    break
                }
                val argument = args[index + 1]
                when (command) {
                    sortingTypeArgument -> {
                        sortingType = try {
                            SortingType.findByType(argument)
                        } catch (exp: RuntimeException) {
                            SortingType.NATURAL
                        }
                    }
                    dataTypeArgument -> {
                        try {
                            dataType = DataType.findByType(argument)
                        } catch (exp: RuntimeException) {
                            println("No data type defined!")
                            return null
                        }
                    }
                    inputFileArgument -> {
                        inputFileName = argument
                    }
                    outputFileArgument -> {
                        outputFileName = argument
                    }
                }
                index += 2
            }
            val ioManager = IoManager.getIoManager(inputFileName, outputFileName)
            return SortArgumentManager(dataType, sortingType, ioManager)
        }


        private fun isAllowedCommand(arg: String): Boolean {
            if (allowedParameters.contains(arg)) {
                return true
            }
            if (SortingType.values().map { it.type }.contains(arg)) {
                return true
            }
            if (DataType.values().map { it.type }.contains(arg)) {
                return true
            }
            return false
        }


        class SortArgumentManager(private val datatype: DataType, private val sortType: SortingType = SortingType.NATURAL, val ioManager: IoManager) : ArgumentManager() {
            override fun perform() {
                val type = DataTypeSorter.getDataType(datatype, ioManager)
                type.sort(sortType)
            }

        }
    }

}
