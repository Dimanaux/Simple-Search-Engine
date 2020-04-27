package search.menu

import search.Main

object Exit : MenuAction {
    override fun toString() = "Exit"

    override fun invoke(main: Main) {
        println("Bye!")
    }
}