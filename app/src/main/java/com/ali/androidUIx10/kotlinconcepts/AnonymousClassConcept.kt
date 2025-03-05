package com.ali.androidUIx10.kotlinconcepts

interface Greeting {
    fun sayHello()
}

fun main() {

    class PlainGreeting{
        fun sayHello(){
            println("Hello, world!")
        }
    }


    val greeting0 = PlainGreeting()
    greeting0.sayHello()

    // Creating a class that implements the Greeting interface
    class GreetingImpl : Greeting {
        override fun sayHello() {
            println("Hello, world!")
        }
    }

    // Using the class
    val greeting1 = GreetingImpl()
    greeting1.sayHello()

    // Creating an anonymous class that implements the Greeting interface
    val greeting2 = object : Greeting {
        override fun sayHello() {
            println("Hello, world!")
        }
    }

    // Using the anonymous class
    greeting2.sayHello()
}