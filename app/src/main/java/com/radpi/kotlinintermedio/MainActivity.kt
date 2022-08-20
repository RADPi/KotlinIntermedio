package com.radpi.kotlinintermedio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread

typealias MyMapList = MutableMap<Int, ArrayList<String>>
typealias MyFun = (Int, String, MyMapList) -> Boolean
typealias MyNestedClass = MyNestedAndInnerClass.MyNestedClass

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enum Classes
//        enumClasses()

        // Nested and Inner Classes
//        nestedAndInnerClasses()

        // Class Inheritance
//        classInheritance()

        // Interfaces
//        interfaces()

        // Visibility modifiers
//        visibilityModifiers()

        // Data Classes
//        dataClasses()

        // Type aliases
//        typeAliases()

        // Destructuring declarations
//        destructuringDeclarations()

        // Extensions
//        extensions()

        // Lambdas
        lambdas()
    }

    private fun lambdas() {
        val myIntList = arrayListOf<Int>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        println(myIntList)
        println("----")

        val myFilterIntList = myIntList.filter {
            it > 5
        }
        println(myFilterIntList)
        println("----")

        val mySumFun = fun(x: Int, y: Int): Int = x + y
        val myMultFun = fun(x: Int, y: Int): Int = x * y

        println(mySumFun(3, 4))
        println(myMultFun(3, 4))

        myAsyncFun("Rafa") {
            println(it)
        }

        println(myOperateFun(3, 4, mySumFun))
        println(myOperateFun(3, 4, myMultFun))
        println(myOperateFun(3, 4) { x, y -> x - y })


    }

    private fun myOperateFun(x: Int, y: Int, myFun: (Int, Int) -> Int): Int {
        return myFun(x, y)
    }

    private fun myAsyncFun(name: String, hello: (String) -> Unit) {
        val myNewString = "Hello $name"
        thread {
            Thread.sleep(3000)
            hello(myNewString)
        }
    }

    private fun extensions() {
        val myDate = Date()
        println(myDate.customFormat())
        println(myDate.formatSize)

        var myDateNullable: Date? = null
        println(myDateNullable.customFormat())
        println(myDateNullable.formatSize)

    }

    private fun destructuringDeclarations() {
        val (nombre, edad, trabajo) = Worker("Rafa", 51, "Programador")
        println("$nombre,$edad, $trabajo")

        val (n, _, t) = Worker("Rafa", 51, "Programador")
        println("$n, $t")

        val rafa = Worker("Rafa", 51, "Programador")
        println(rafa.component1())
        println(rafa.component2())
        println(rafa.component3())

        val myMap = mapOf(1 to "Pepe", 2 to "Argento", 3 to "Moni")
        for ((key, value) in myMap) {
            println("$key - $value")
        }

    }

    private var myMap: MyMapList = mutableMapOf()

    private fun typeAliases() {
        var myNewMap: MyMapList = mutableMapOf()

    }

    private fun dataClasses() {
        val rafa = Worker("Rafa", 51, "Programador")
        rafa.lastWork = "Comprador"

        val sara = Worker()

        // equals & hashCode
        if (rafa == sara) println("son iguales")
        else println("no son iguales")

        val copy = Worker("Rafa", 51, "Programador")
        copy.lastWork = "Comprador"

        if (rafa == copy) println("son iguales")
        else println("no son iguales")

        // toString
        println(rafa.toString())

        // copy
        var youngRafa = rafa.copy(age = 21)
        println(youngRafa.toString())

        //componentN
        val (name2, age) = rafa   // son posicionales
        println(name2)
        println(age)
    }

    private fun visibilityModifiers() {
//        val visibility = Visibility()
//        visibility.sayMyName()
//
//        visibility.name = "Rafa"
//        visibility.sayMyName()

        val visibilityTwo = VisibilityTwo()
//        visibilityTwo.sayMyNameTwo()


    }

    private fun interfaces() {
        val gamer = Person("Rafa", 51)
        gamer.play()
        gamer.stream()
    }

    private fun classInheritance() {
        val person = Person("Pepe", 49)

        val programmer = Programmer("Rafa", 51, "Kotlin")
        programmer.work()
        programmer.sayLanguage()
        programmer.goToWork()

        val designer = Designer("YoNo", 31)
        designer.work()
        designer.goToWork()
    }

    private fun nestedAndInnerClasses() {
        // Clase Anidada(nested)
        val myNestedClass = MyNestedClass()
        val sum = myNestedClass.sum(2, 3)
        println("El resultado de la suma es $sum")

        // Clase interna(inner)
        val myInnerClass = MyNestedAndInnerClass().MyInnerClass()
        val sumTwo = myInnerClass.sumTwo(4)
        println("El resultado de la suma es $sumTwo")

    }

    enum class Direction(val dir: Int) {
        NORTH(0),
        EAST(90),
        SOUTH(180),
        WEST(270);

        fun description(): String {
            return when (this) {
                NORTH -> "La dirección es norte"
                SOUTH -> "La dirección es sur"
                EAST -> "La dirección es este"
                WEST -> "La dirección es oeste"
            }
        }
    }

    private fun enumClasses() {
        var userDirection: Direction? = null
        println("Direccion $userDirection")

        userDirection = Direction.NORTH
        println("Direccion $userDirection")

        userDirection = Direction.EAST
        println("Direccion $userDirection")

        println("Propiedad name: ${userDirection.name}")
        println("Propiedad ordinal: ${userDirection.ordinal}")
        println("Propiedad dir: ${userDirection.dir}")
        println("Funcion description: ${userDirection.description()}")


    }
}