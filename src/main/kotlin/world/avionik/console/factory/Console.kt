package world.avionik.console.factory

import org.jline.reader.LineReader
import org.jline.reader.impl.completer.ArgumentCompleter
import org.jline.reader.impl.completer.StringsCompleter
import world.avionik.console.factory.input.ConsoleInput
import world.avionik.console.factory.terminal.TerminalFactory
import kotlin.system.exitProcess

/**
 * @author Niklas Nieberler
 */

abstract class Console(
    vararg consoleInput: ConsoleInput
) {

    private val defaultConsoleInputs = arrayListOf(
        *consoleInput,
        ConsoleInput("shutdown", "stop") { exitProcess(0) },
    )

    init {
        val lineReader = createConsoleReader()
        Thread { executeConsole(lineReader) }.start()
    }

    private fun createConsoleReader(): LineReader {
        val consoleInputNames = this.defaultConsoleInputs.map { it.name.toList() }
        val argumentCompleter = ArgumentCompleter(
            StringsCompleter(consoleInputNames.flatten())
        )
        return TerminalFactory.create(argumentCompleter)
    }

    private fun executeConsole(lineReader: LineReader) {
        val readLine = lineReader.readLine()
        this.defaultConsoleInputs
            .filter { it.contains(readLine.replace(" ", "")) }
            .forEach { it.executor.execute() }
        executeConsole(lineReader)
    }

}