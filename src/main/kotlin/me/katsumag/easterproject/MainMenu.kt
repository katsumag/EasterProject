package me.katsumag.easterproject

import me.katsumag.easterproject.nac.NoughtsAndCrosses
import tornadofx.*

class MainMenu : View() {

    override val root = borderpane {

        top = label("Computer Science Easter Project") {
            useMaxWidth = true
        }

        left = vbox {
            useMaxSize = true
            button("Noughts & Crosses") {
                action { NoughtsAndCrosses().openWindow() }
            }
        }

        right = vbox {
            useMaxSize = true
            button("Big Vale Quiz")
        }

    }

}