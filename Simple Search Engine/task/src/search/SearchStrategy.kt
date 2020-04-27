package search

enum class SearchStrategy {
    ANY {
        override fun find(query: Token, search: Search): Set<String> {
            val hashSet = HashSet<String>()
            query.keys.forEach { key ->
                val found = search.find(key)
                hashSet.addAll(found)
            }
            return hashSet
        }
    },
    NONE {
        override fun find(query: Token, search: Search): Set<String> {
            val all = search.all()
            val toExclude = ANY.find(query, search)
            return all - toExclude
        }
    },
    ALL {
        override fun find(query: Token, search: Search): Set<String> {
            val sets = query.keys.map { search.find(it) }
            return sets.reduce { a, b -> a intersect b }
        }
    };

    abstract fun find(query: Token, search: Search): Set<String>
    fun find(query: String, search: Search): Set<String> = find(Token(query), search)
}
