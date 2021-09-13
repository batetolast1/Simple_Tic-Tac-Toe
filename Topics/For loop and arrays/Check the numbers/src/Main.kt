fun main() {
    val n = readLine()!!.toInt()
    val numbers = IntArray(n) { readLine()!!.toInt() }
    val (p, m) = readLine()!!.split(" ").take(2).map { it.toInt() }.toTypedArray()
    var isPAndMNextToEachOther = false

    for (i in 0 until numbers.size - 1) {
        if (numbers[i] == p && numbers[i + 1] == m || numbers[i] == m && numbers[i + 1] == p) {
            isPAndMNextToEachOther = true
            break
        }
    }

    print(if (isPAndMNextToEachOther) "NO" else "YES")
}