fun main() = readLine()!!.toCharArray().groupBy { it }.count { it.value.size == 1 }.let(::print)
