const val TICKET_LENGTH = 6

fun main() = readLine()!!
    .toCharArray(endIndex = TICKET_LENGTH)
    .map { it.code }
    .chunked(TICKET_LENGTH / 2)
    .let { it[0].sum() == it[1].sum() }
    .let { if (it) "Lucky" else "Regular" }
    .let(::print)
