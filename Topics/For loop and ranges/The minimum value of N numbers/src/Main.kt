fun main() {
    var min = Integer.MAX_VALUE

    repeat(readLine()!!.toInt()) {
        val possibleMin = readLine()!!.toInt()
        if (possibleMin < min) {
            min = possibleMin
        }
    }

    print(min)
}