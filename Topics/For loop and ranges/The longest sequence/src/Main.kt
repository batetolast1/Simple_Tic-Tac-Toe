fun main() {
    val count = readLine()!!.toInt()
    var previousNumber = Integer.MIN_VALUE

    var nonDescending = 0
    var nonDescendingMax = 0

    repeat(count) {
        val nextNumber = readLine()!!.toInt()

        if (previousNumber <= nextNumber) {
            nonDescending++
        } else {
            nonDescending = 1
        }

        if (nonDescending > nonDescendingMax) {
            nonDescendingMax = nonDescending
        }

        previousNumber = nextNumber
    }

    print(nonDescendingMax)
}
