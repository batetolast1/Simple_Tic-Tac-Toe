fun main() {
    var num = Integer.MIN_VALUE
    var isAscending = true

    repeat(readLine()!!.toInt()) {
        val nextNum = readLine()!!.toInt()
        if (nextNum > num) {
            num = nextNum
        } else {
            isAscending = false
        }
    }

    print(if (isAscending) "YES" else "NO")
}