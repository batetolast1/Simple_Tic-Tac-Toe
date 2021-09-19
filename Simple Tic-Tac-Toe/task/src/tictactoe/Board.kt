package tictactoe

interface Board {

    fun printBoard()

    fun makeNextMove()

    fun changePlayer()

    fun getBoardState(): BoardState
}
