fun main() {
    val rows = (1..5).toMutableList()
    val cols = (1..5).toMutableList()
    repeat(3) {
        val (x, y) = readLine()!!.split("\\s+".toRegex()).map { it.toInt() }
        rows.remove(x)
        cols.remove(y)
    }
    println(rows.joinToString(separator = " "))
    println(cols.joinToString(separator = " "))
    for (i in 1..4) {
        loop@ for (j in 1..3) {
            for (k in 1..2) {
                if (i == 2 || j == 3 || k == 2) break@loop
                print("$k")
            }
        }
    }
}