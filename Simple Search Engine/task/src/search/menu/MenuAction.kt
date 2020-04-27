package search.menu

import search.Main

interface MenuAction {
    override fun toString(): String
    operator fun invoke(main: Main)
}
