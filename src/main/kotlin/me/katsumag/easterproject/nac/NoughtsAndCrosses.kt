package me.katsumag.easterproject.nac

import javafx.scene.control.Button
import javafx.scene.layout.Pane
import tornadofx.View
import tornadofx.gridpane
import tornadofx.opcr
import tornadofx.row

class NoughtsAndCrosses : View("Noughts & Crosses") {

    override val root = gridpane {
        row {
            addCell {  }
            addCell {  }
            addCell {  }
        }

        row {
            addCell {  }
            addCell {  }
            addCell {  }
        }

        row {
            addCell {  }
            addCell {  }
            addCell {  }
        }
    }

    fun Pane.addCell(op: (Button.() -> Unit)) = opcr(this, find(Cell::class).root, op)

}

