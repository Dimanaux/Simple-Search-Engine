package search

data class Token(val value: String) {
    fun matches(word: String): Boolean = value.contains(word, true)

    val keys: List<String> = value.toLowerCase().split(" ")

    override fun toString(): String = value
}
