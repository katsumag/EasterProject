package me.katsumag.easterproject.nac

object GameController {

    var player = CellState.CROSS

    fun switchPlayer() {
        player = when(player) {
            CellState.CROSS -> CellState.NOUGHT
            CellState.NOUGHT -> CellState.CROSS
            else -> CellState.EMPTY
        }
    }

}