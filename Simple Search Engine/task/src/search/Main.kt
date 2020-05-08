package search

import java.util.*

class Main(private val scanner: Scanner) {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val main = Main(Scanner(System.`in`))
            val people = main.readInt("Enter the number of people:")
            val data = main.readLines(people, "Enter all people:")
            val search = Search(data.map(Token.Companion::from))
            val queries = main.readInt("Enter the number of search queries:")
            main.eachLine(queries, "Enter data to search people:") { query ->
                val result: List<String> = search.find(query)
                main.putList(result, "Found people:", "No matching people found.")
            }
        }
    }

    fun readInt(hint: String): Int {
        println(hint)
        return readLine().toInt()
    }

    fun readLine(): String = scanner.nextLine()

    fun readLines(count: Int, hint: String): List<String> {
        println(hint)
        return MutableList(count) { readLine() }
    }

    fun eachLine(count: Int, hint: String, action: (String) -> Unit) {
        repeat(count) {
            println(hint)
            action(readLine())
        }
    }

    fun putList(list: List<String>, hint: String, failHint: String) {
        if (list.isEmpty()) {
            println(failHint)
        } else {
            println(hint)
        }
        list.forEach(::println)
    }
}
