package search

class Search(private val data: List<Token>) {
    private val index = HashMap<String, MutableSet<Token>>()

    init {
        data.forEach { token ->
            token.keys.forEach { key ->
                index.computeIfAbsent(key) { HashSet() }
                index[key]?.add(token)
            }
        }
    }

    fun all() = data.map(Token::value).toMutableSet()

    fun find(query: String): Set<String> =
            index[query.toLowerCase()]?.map(Token::value)?.toSet()
                    ?: emptySet()
}
