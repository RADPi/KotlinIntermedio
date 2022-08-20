package com.radpi.kotlinintermedio

import org.intellij.lang.annotations.Language

class Programmer(name: String, age: Int, val language: String) : Person(name, age) {

    override fun work() {
        println("Esta persona está programando")
    }

    fun sayLanguage(){
        println("Este programador usa el lenguaje ${language}")
    }

    override fun goToWork() {
        super.goToWork()
        println("...JomOfis")
    }
}