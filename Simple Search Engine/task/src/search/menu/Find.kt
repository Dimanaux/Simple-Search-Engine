package search.menu

import search.Main
import search.Search
import search.SearchStrategy

class Find(val search: Search) : MenuAction {
    override fun toString() = "Find a person"

    override fun invoke(main: Main) {
        val strategyString = main.readLine("Select a matching strategy: ALL, ANY, NONE\n")
        val searchStrategy = SearchStrategy.valueOf(strategyString)
        val query = main.readLine("Enter a name or email to search all suitable people.\n")
        val result = searchStrategy.find(query, search)
        main.putList(result, "", "No matching people found.\n")
    }
}
