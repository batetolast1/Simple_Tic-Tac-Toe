fun main() {
    val size = readLine()!!.toInt()
    val array = IntArray(size)
    var triplets = 0

    for (i in 0..array.lastIndex) {
        array[i] = readLine()!!.toInt()

        if (i >= 2 && array[i - 2] + 1 == array[i - 1] && array[i - 1] + 1 == array[i]) {
            triplets++
        }
    }

    print(triplets)
}