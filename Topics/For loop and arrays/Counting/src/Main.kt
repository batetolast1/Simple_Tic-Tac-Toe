fun main() {
    val size = readLine()!!.toInt()
    val array = IntArray(size)

    for (i in 0..array.lastIndex) {
        array[i] = readLine()!!.toInt()
    }

    val m = readLine()!!.toInt()
    print(array.count { it == m })
}