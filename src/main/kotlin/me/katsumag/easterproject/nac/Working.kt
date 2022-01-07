package me.katsumag.easterproject.nac

import javafx.application.Application
import javafx.beans.property.SimpleIntegerProperty
import javafx.scene.control.Button
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import me.katsumag.easterproject.util.SVGPath
import tornadofx.*

enum class CellValue {
    no_player, cross, circle
}

object GridLogic {
    var currentPlayer = CellValue.cross
    fun togglePlayer() {
        currentPlayer = when(currentPlayer){
            CellValue.cross -> CellValue.circle
            CellValue.circle -> CellValue.cross
            else -> CellValue.no_player
        }
    }
}

fun main(args: Array<String>){
    Application.launch(SimpleTicTacToe::class.java, *args)
}

class SimpleTicTacToe:App(SimpleTicTacToeGrid::class)

class SimpleTicTacToeGrid : View("Simple Tic Tac Toe") {

    override val root = gridpane {
        row {
            ticTacToeCell {  }
            ticTacToeCell {  }
            ticTacToeCell {  }
        }
        row {
            ticTacToeCell {  }
            ticTacToeCell {  }
            ticTacToeCell {  }
        }
        row {
            ticTacToeCell {  }
            ticTacToeCell {  }
            ticTacToeCell {  }
        }
    }

    fun Pane.ticTacToeCell(op: (Button.() -> Unit)) =
        opcr(this, tornadofx.find(SimpleTicTacToeCell::class).root, op)


}

class SimpleTicTacToeCell : ItemFragment<CellValue>() {

    private val associatedPlayerProperty = SimpleIntegerProperty(CellValue.no_player.ordinal)
    var associatedPlayer by associatedPlayerProperty

    override val root = button {
        prefWidth = 60.0
        prefHeight = 60.0
        graphic = group {

            group {
                /*
                Gotten from drawing in inkscape, exporting as plain svg
                Opening in GIMP with imported paths and merge imported paths boxes checked
                Windows -> Dockable Dialogues -> paths
                Imported Path -> Export Path
                Gets detected by SVGPath#get
                 */
                svgpath(SVGPath.get("cross_path.svg")) {
                    stroke = Color.BLACK
                    strokeWidth = 5.0
                }

                visibleWhen { associatedPlayerProperty.booleanBinding{ it == CellValue.cross.ordinal } }
            }

            group {
                svgpath(SVGPath.get("circle_path.svg")) {
                    stroke = Color.BLACK
                    strokeWidth = 5.0
                }

                visibleWhen { associatedPlayerProperty.booleanBinding{ it == CellValue.circle.ordinal } }
            }
        }

        setOnMouseClicked {
            if (associatedPlayer == CellValue.no_player.ordinal){
                associatedPlayer = GridLogic.currentPlayer.ordinal
                GridLogic.togglePlayer()
            }
        }
    }
}