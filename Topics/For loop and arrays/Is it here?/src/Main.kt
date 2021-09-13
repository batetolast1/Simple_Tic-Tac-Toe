fun main() {
    val n = readLine()!!.toInt()
    val numbers = IntArray(n) { readLine()!!.toInt() }
    val m = readLine()!!.toInt()

    print(if (m in numbers) "YES" else "NO")
}