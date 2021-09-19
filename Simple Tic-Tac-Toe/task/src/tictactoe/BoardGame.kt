package tictactoe

interface BoardGame<Board> {

    val board: Board

    fun play()

    fun isInProgress(): Boolean

    fun printResult()
}
