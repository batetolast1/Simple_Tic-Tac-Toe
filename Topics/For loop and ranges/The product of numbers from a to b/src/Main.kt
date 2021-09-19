fun main() = (readLine()!!.toLong() until readLine()!!.toLong())
    .reduce { product, element -> product * element }
    .let(::print)
