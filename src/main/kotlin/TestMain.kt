import world.avionik.console.factory.Console
import world.avionik.console.factory.input.ConsoleInput
import world.avionik.console.factory.input.ConsoleInputExecutor

fun main() {
    TestMain()
}

class TestMain : Console(
    ConsoleInput("test") { println("Second") },
    ConsoleInput("test2", executor = Executor())
)

class Executor : ConsoleInputExecutor {
    override fun execute() {
        println("Hallo wazzup")
    }
}