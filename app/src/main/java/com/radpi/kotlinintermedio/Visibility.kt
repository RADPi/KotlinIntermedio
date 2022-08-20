package com.radpi.kotlinintermedio

private class Visibility {

    var name: String? = null

    private fun sayMyName(){
        name?.let {
            println("Mi nombre es $it")
        } ?: run{
            println("No tengo nombre")
        }
    }
}

open class VisibilityTwo{
    protected fun sayMyNameTwo(){
        val visibility = Visibility()
        visibility.name = "Rafa"
    }
}

class VisibiltyThree: VisibilityTwo(){

    fun sayMyNameThree(){
        sayMyNameTwo()
    }
}

