fun main() {
    // put your code here
    val n1 = readLine()!!.toInt()
    val n2 = readLine()!!.toInt()
    val n3 = readLine()!!.toInt()
    print(calculateNumOfDesks(n1) + calculateNumOfDesks(n2) + calculateNumOfDesks(n3))
}
fun calculateNumOfDesks(numOfStudents: Int): Int {
    return if (numOfStudents % 2 == 0) numOfStudents / 2 else numOfStudents / 2 + 1
}