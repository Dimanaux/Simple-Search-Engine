package search.menu

import search.Main

class PrintAll(private val people: List<String>) : MenuAction {
    override fun toString() = "Print all people"

    override fun invoke(main: Main) {
        main.putList(people, "", "No matching people found.\n")
    }
}
