package world.avionik.console.factory.terminal

import org.jline.reader.Completer
import org.jline.reader.LineReader
import org.jline.reader.LineReaderBuilder
import org.jline.reader.impl.DefaultParser
import org.jline.terminal.Terminal
import org.jline.terminal.TerminalBuilder

/**
 * @author Niklas Nieberler
 */

object TerminalFactory {

    /**
     * Creates a jline LineReader with line completer
     * @param completer the line completions
     */
    fun create(completer: Completer): LineReader {
        val defaultParser = DefaultParser()
        return LineReaderBuilder.builder()
            .terminal(createTerminalBuilder())
            .parser(defaultParser)
            .completer(completer)
            .build()
    }

    private fun createTerminalBuilder(): Terminal {
        return TerminalBuilder.builder()
            .system(true)
            .streams(System.`in`, System.out)
            .encoding(Charsets.UTF_8)
            .dumb(true)
            .build()
    }

}