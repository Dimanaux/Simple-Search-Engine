package search.menu

import search.Main

class Menu(vararg actions: MenuAction) {
    private val actionsMap = LinkedHashMap<Int, MenuAction>()
    private val exit: Exit = Exit

    init {
        for ((i, action) in actions.withIndex()) {
            actionsMap[i + 1] = action
        }
        actionsMap[0] = exit
    }

    fun select(index: Int) = actionsMap[index] ?: IncorrectAction

    override fun toString(): String = "=== Menu ===\n" +
            actionsMap.asIterable()
                    .joinToString("\n") { (i, a) -> "$i. $a" }

    fun loop(main: Main) {
        do {
            val commandId = main.readInt("$this\n")
            val command = select(commandId)

            command.invoke(main)
        } while (command != exit)
    }
}
