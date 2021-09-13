fun main() {
    val n = readLine()!!.toInt()
    val numbers = IntArray(n) { readLine()!!.toInt() }
    val (p, m) = readLine()!!.split(" ").take(2).map { it.toInt() }.toTypedArray()

    print(if (p in numbers && m in numbers) "YES" else "NO")
}