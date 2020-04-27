package search

import search.menu.Find
import search.menu.Menu
import search.menu.PrintAll
import java.io.File
import java.util.*

class Main(private val scanner: Scanner) {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val data = File(args[1]).readLines()
            val main = Main(Scanner(System.`in`))
            val tokens = data.map(::Token)
            val search = Search(tokens)
            val menu = Menu(Find(search), PrintAll(data))
            menu.loop(main)
        }
    }

    fun readInt(hint: String): Int {
        print(hint)
        return readLine().toInt()
    }

    fun readLine(hint: String = ""): String {
        print(hint)
        return scanner.nextLine()
    }

    fun readLines(count: Int, hint: String = ""): List<String> {
        print(hint)
        return MutableList(count) { readLine() }
    }

    fun putList(list: Collection<String>, hint: String = "", failHint: String = "") {
        if (list.isEmpty()) {
            print(failHint)
        } else {
            print(hint)
        }
        list.forEach(::println)
    }
}
