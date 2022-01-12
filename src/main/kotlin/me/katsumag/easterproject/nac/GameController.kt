package me.katsumag.easterproject.nac

object GameController {

    var player = CellState.CROSS
    val cells = mutableListOf<Cell>()
    //Workaround to signal first click, so all cells are added to `cells` and the list can be ordered.
    private var firstCheck = true
    private lateinit var horizontalCells: List<List<Cell>>
    private lateinit var verticalCells: List<List<Cell>>

    fun switchPlayer() {
        player = when(player) {
            CellState.CROSS -> CellState.NOUGHT
            CellState.NOUGHT -> CellState.CROSS
            else -> CellState.EMPTY
        }
    }

    //sorts the 9 cells into a 2d arry [[1,2,3][4,5,6][7,8,9]] to get rows.
    private fun sortHorizontalCells() = cells.chunked(3)

    private fun sortVerticalCells(): List<List<Cell>> {
        //TODO: Not Implemented
        return listOf()
    }

    fun checkCells(): Boolean {

        if (firstCheck) {
            firstCheck = false

            horizontalCells = sortHorizontalCells()
            verticalCells = sortVerticalCells()

        }

        return false
    }

}