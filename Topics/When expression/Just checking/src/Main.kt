fun main() = readLine()!!.let {
    when (it) {
        "1", "3", "4" -> "No!"
        "2" -> "Yes!"
        else -> "Unknown number"
    }
}.let(::print)
