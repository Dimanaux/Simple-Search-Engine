package search

interface Token {
    fun matches(word: String): Boolean
    val value: String
        get() = toString()

    override fun toString(): String

    companion object {
        fun from(string: String) = object : Token {
            override fun toString() = string
            override fun matches(word: String) =
                    string.contains(word, true)
        }
    }
}
