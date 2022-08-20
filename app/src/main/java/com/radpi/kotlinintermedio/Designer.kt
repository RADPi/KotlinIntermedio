package com.radpi.kotlinintermedio

class Designer(name: String, age: Int) : Person(name, age) {

    override fun work() {
        println("Esta persona está diseñando")
    }
}