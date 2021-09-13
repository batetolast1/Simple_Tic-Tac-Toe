fun main() = readLine()!!.let {
    when (it) {
        "1" -> "move up"
        "2" -> "move down"
        "3" -> "move left"
        "4" -> "move right"
        "0" -> "do not move"
        else -> "error!"
    }
}.let(::print)