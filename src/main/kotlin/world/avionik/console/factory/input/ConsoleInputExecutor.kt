package world.avionik.console.factory.input

/**
 * @author Niklas Nieberler
 */

fun interface ConsoleInputExecutor {

    /**
     * This method is executed when a certain input is sent to the console.
     */
    fun execute()

}