package search

class Search(val data: List<Token>) {
    fun find(query: String): List<String> {
        return data.filter { it.matches(query) }
                .map(Token::toString)
    }
}
