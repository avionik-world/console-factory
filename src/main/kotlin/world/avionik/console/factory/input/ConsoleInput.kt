package world.avionik.console.factory.input

/**
 * @author Niklas Nieberler
 */

class ConsoleInput(
    vararg val name: String,
    val executor: ConsoleInputExecutor
) {

    /**
     * Returns true if name is found in the array.
     */
    fun contains(name: String): Boolean {
        return this.name.contains(name)
    }

}