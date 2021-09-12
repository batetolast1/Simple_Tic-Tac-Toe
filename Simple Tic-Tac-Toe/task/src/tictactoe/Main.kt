package tictactoe

fun main() {
    printEnterCells()
    val input = readLine()!!
    val board = Board(input)
    board.printBoard()
}

fun printEnterCells() {
    print("Enter cells: ")
}
