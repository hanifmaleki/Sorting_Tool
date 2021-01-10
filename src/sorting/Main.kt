package sorting

import sorting.argmanager.ArgumentManager


fun main(args: Array<String>) {

    val command = ArgumentManager.getCommand(args)
    command?.perform()

}

