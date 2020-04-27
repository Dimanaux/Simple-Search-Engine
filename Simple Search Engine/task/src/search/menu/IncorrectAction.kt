package search.menu

import search.Main

object IncorrectAction : MenuAction {
    override fun toString(): String = "Incorrect option! Try again."
    override fun invoke(main: Main) = println(this)
}