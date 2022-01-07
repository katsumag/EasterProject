package me.katsumag.easterproject.util

import java.io.InputStreamReader

object SVGPath {

    /*
    split[2] because theres id= as well
    drop 1 for the leading "
    dropLast 12 for trailing xml garbage
     */
    fun get(file: String) = InputStreamReader(this.javaClass.classLoader.getResourceAsStream(file)).readText().split("d=")[2].drop(1).dropLast(12)

}