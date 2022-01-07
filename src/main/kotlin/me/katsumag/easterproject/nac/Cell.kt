package me.katsumag.easterproject.nac

import javafx.beans.property.SimpleIntegerProperty
import javafx.scene.paint.Color
import me.katsumag.easterproject.util.SVGPath
import tornadofx.*

class Cell : ItemFragment<CellState>() {

    private val playerProperty = SimpleIntegerProperty(CellState.EMPTY.ordinal)
    var player by playerProperty

    override val root = button {
        prefWidth = 60.0
        prefHeight = 60.0
        graphic = group {

            //crosses
            group {
                svgpath(SVGPath.get("cross_path.svg")) {
                    stroke = Color.BLACK
                    strokeWidth = 5.0
                }

                visibleWhen { playerProperty.booleanBinding { it == CellState.CROSS.ordinal } }

            }

            //noughts
            group {
                svgpath(SVGPath.get("circle_path.svg")) {
                    stroke = Color.BLACK
                    strokeWidth = 5.0
                }

                visibleWhen { playerProperty.booleanBinding { it == CellState.NOUGHT.ordinal } }

            }

            //click action
            setOnMouseClicked {
                if (player == CellState.EMPTY.ordinal) {
                    player = GameController.player.ordinal
                    GameController.switchPlayer()
                }
            }

        }
    }

}