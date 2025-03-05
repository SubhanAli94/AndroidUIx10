package com.ali.androidUIx10.kotlinconcepts

interface Vehicle {
    fun startEngine(): String
    fun stopEngine(): String
}

class Car : Vehicle {
    override fun startEngine(): String {
        return "Car engine started."
    }

    override fun stopEngine(): String {
        return "Car engine stopped."
    }
}

class Motorcycle : Vehicle {
    override fun startEngine(): String {
        return "Motorcycle engine started."
    }

    override fun stopEngine(): String {
        return "Motorcycle engine stopped."
    }
}

fun main() {
    val car: Vehicle = Car()
    val motorcycle = Motorcycle()

    println(car.startEngine())
    println(motorcycle.stopEngine())
}
