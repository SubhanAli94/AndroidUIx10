package com.ali.androidUIx10.kotlinconcepts

/*
fun declareVariables() {
    val name: String = "John"  // Immutable (Cannot change)
    var age: Int = 25         // Mutable (Can change)
    age = 26

    println("Name: $name, Age: $age")
}
*/

/*
fun variablesWithExplicitTypes() {

    //Type inference (Kotlin can detect types automatically)

    val number: Int = 10
    val pi: Double = 3.14
    val float: Float = 3.14f
    val isActive: Boolean = true
    val letter: Char = 'A'
    val message: String = "Hello Kotlin"

    println("Number: $number, Pi: $pi, Float: $float, Active: $isActive, Letter: $letter, Message: $message")
}
*/

/*
fun conditionalStatements() {
    val x = 10

    if (x > 5) {
        println("x is greater than 5")
    } else {
        println("x is 5 or less")
    }

    // Shorter Ternary Style
    val result = if (x > 5) "Greater" else "Smaller"

    println(result)

}
*/

/*
fun whenExpression(day: Int): String {
    val dayName = when (day) {
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        else -> "Unknown"
    }
    return dayName
}
*/

/*
fun forLoop(length: Int) {
    println("\nFor Loop")
    for (i in 1..length) {
        println("Count: $i")
    }
}
 */

/*
fun whileLoop(length: Int) {
    var count = length  // Create a mutable variable initialized with the parameter

    println("\nWhile Loop")
    while (count > 0) {
        println("Count: $count")
        count--          // Decrement the mutable variable instead
    }
}
*/

/*
fun lambdaExpressions() {
    val sum = { a: Int, b: Int -> a - b }
    println("\nLambda Expression Result: ${sum(1, 3)}")  // Output: 8
}
*/

/*
fun calculator(a: Float, b: Float, operationName: String) {
    val result = when (operationName) {
        "add" -> a + b
        "subtract" -> a - b
        "multiply" -> a * b
        "divide" -> a / b
        else -> throw IllegalArgumentException("Invalid operation: $operationName")
    }

    println("Calculator Result: $result")
}
*/

/*
fun calculator(a: Float, b: Float, operation: (Float, Float) -> Float) {
    println("Smart Calculator Result: ${operation(a, b)}")
}
*/

/*
fun nullSafety(){
    var name: String? = null  // Nullable variable
    println(name?.length)  // Safe call (Avoids NullPointerException)
    println(name!!.length)  // When variable is confirmed non-null
    println(name ?: "Default Name")  // Elvis operator
}
*/

//Class
/*
class Person(val name: String, private var age: Int) {

//    init {
//        age = if (age < 0) 0 else age
//    }

//    private val hobbies = mutableListOf<String>()
//    fun addHobby(hobby: String) {
//        hobbies.add(hobby)
//    }
//
//    fun listHobbies() {
//        println("$name's hobbies:")
//        for (hobby in hobbies) {
//            println("- $hobby")
//        }
//    }

    fun introduce() {
        println("Hi, I'm $name and I'm $age years old.")
    }
}
*/

/*
open class Animal {

//    init {
//        println("Hello from Animal")
//    }

    open fun makeSound() {
        println("Animal makes a sound")
    }
}
class Dog : Animal() {
    override fun makeSound() {
        println("Dog barks")
    }
}
*/

/*
fun String.reverseWords(): String {
    return this.split(" ")
        .reversed()
        .joinToString(" ")
}
 */


fun main() {

    //Functions
//    declareVariables()
//
//    variablesWithExplicitTypes()
//
//    conditionalStatements()
//
//    print("Day Name is: ${whenExpression(2)}\n")
//
//    forLoop(10)
//
//    whileLoop(5)
//
//    lambdaExpressions()
//
//    //Functions Overloading
//    calculator(1.0f, 2.0f, "add")
//
//    //Smart Calculator
//    calculator(1f, 2f) { a, b -> a * b }
//
//    //Smart Calculator
//    calculator(10f, 20f) { a, b -> a / b }

    // nullSafety()

    //Classes
//    println("\nClasses Output\n")
//    val person = Person("Alice", 30)
//    person.introduce()
//    person.addHobby("Reading")
//    person.addHobby("Traveling")
//    person.listHobbies()

    //Inheritence
//    val dog = Dog()
//    dog.makeSound()  // Output: Dog barks

//    val sentence = "Kotlin is fun"
//    println(sentence.reverseWords())  // Output: "fun is Kotlin"

}