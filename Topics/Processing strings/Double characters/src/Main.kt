fun main() = readLine()!!.toCharArray()
    .joinToString("") { ch -> ch.toString() + ch.toString() }
    .let(::print)