package tictactoe

class TicTacToeGame(override val board: TicTacToeBoard) : BoardGame<TicTacToeBoard> {

    override fun play() {
        while (isInProgress()) {
            board.printBoard()
            board.makeNextMove()
            board.changePlayer()
        }

        board.printBoard()
        printResult()
    }

    override fun isInProgress() = board.getBoardState() == BoardState.NOT_FINISHED

    override fun printResult() = println(board.getBoardState().description)
}
