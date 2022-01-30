package me.katsumag.easterproject.nac

object GameController {

    var player = CellState.CROSS
    val cells = mutableListOf<Cell>()
    //Workaround to signal first click, so all cells are added to `cells` and the list can be ordered.
    private var firstCheck = true
    //Lists for horizontal, vertical and diagonal win conditions
    private lateinit var horizontalCells: List<List<Cell>>
    private lateinit var verticalCells: List<List<Cell>>
    private lateinit var diagonalCells: List<List<Cell>>

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

        val verticalCells = mutableListOf<MutableList<Cell>>(mutableListOf(), mutableListOf(), mutableListOf())

        for (i in horizontalCells.indices) {
            for (col in horizontalCells[i].indices) {
                verticalCells[col].add(horizontalCells[i][col])
            }
        }

        return verticalCells
    }

    private fun sortNeededDiagonals(): List<List<Cell>> {
        return listOf(
          listOf(this.horizontalCells[0][0], this.horizontalCells[1][1], this.horizontalCells[2][2])
          listOf(this.horizontalCells[0][2], this.horizontalCells[1][1], this.horizontalCells[2][0])
        ) 
    }

    fun checkCells(): Boolean {

        //TODO: Find better way to do this.

        if (firstCheck) {
            firstCheck = false

            horizontalCells = sortHorizontalCells()
            verticalCells = sortVerticalCells()
            diagonalCells = sortNeededDiagonals()

        }

        if (checkList(horizontalCells)) { return true }
        if (checkList(verticalCells)) { return true }
        if (checkList(diagonalCells)) { return true }

        return false
    }

    private fun checkList(listt: List<List<Cell>>) {
        return (!(verticalCells.filter { it.all { it.player } }.isNullOrEmpty()))
    }

}