fun main() = readLine()!!.let {
    when {
        it.isEmpty() -> ""
        it.first() == 'i' -> it.drop(1).toInt() + 1
        it.first() == 's' -> it.drop(1).reversed()
        else -> it
    }
}.let(::print)
