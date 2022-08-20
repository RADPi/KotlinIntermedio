package com.radpi.kotlinintermedio

open class Person (name: String, age: Int): Work(), Game {
    // Cualquier clase tiene una superclase comun "Any"
    open fun work(){
        println("Esta persona está trabajando...")
    }

    override fun goToWork() {
        println("Esta persona va a trabajar...")
    }

    override val game = "Among Us"

    override fun play() {
        println("Esta persona está jugando a $game")
    }

}