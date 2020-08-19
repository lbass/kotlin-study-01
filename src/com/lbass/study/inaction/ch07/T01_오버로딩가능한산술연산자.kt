package com.lbass.study.inaction.ch07

import java.lang.Exception

data class Point(val value: Int = 0) {
    // '*' 연산자 오버로딩
    operator fun times(other: Point): Point {
        println("times")
        return Point(value * other.value)
    }

    operator fun times(scale: Double): Point {
        println("Double times")
        return Point((value * scale).toInt())
    }

    // '/' 연산자 오버로딩
    operator fun div(other: Point): Point {
        println("div")
        return Point(value / other.value)
    }

    // '%' 연산자 오버로딩
    operator fun rem(other: Point): Point {
        println("rem")
        return Point(value % other.value)
    }

    // '+' 연산자 오버로딩
    operator fun plus(other: Point): Point {
        println("plus")
        return Point(value + other.value)
    }

    // '-' 연산자 오버로딩
    operator fun minus(other: Point): Point {
        println("minus")
        return Point(value - other.value)
    }
}

/**
 * char 연산자 오버로딩
 */
operator fun Char.times(count: Int): Long {
    println("Double.times")
    return toString().repeat(count).toLong()
}

fun main(args: Array<String>) {
    val a = Point(10)
    val b = Point(20)

    println(a + b)
    println(a - b)
    println(a * b)
    println(a % b)
    println(a / b)

    println(a * 1.5)

    try {
        println('1' * 10)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}