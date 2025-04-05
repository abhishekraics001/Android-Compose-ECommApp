package com.example.mysystemtest

fun main() {
    val result = 10.AddTwo(20)
    11 AddTwo 20
    println(result)
}

infix fun Int.AddTwo(a:Int): Int{
    return this + a
}

// extension function example
fun Int.AddTwo(x: Int, y: Int): Int {
    return this + x + y
}