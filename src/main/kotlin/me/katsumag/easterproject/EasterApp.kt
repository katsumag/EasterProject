package me.katsumag.easterproject

import tornadofx.App
import tornadofx.launch

fun main(args: Array<String>) = launch<EasterApp>(args)

class EasterApp : App(MainMenu::class) 