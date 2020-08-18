package com.lbass.study.code08

import java.lang.StringBuilder

/*
val sum = { x: Int, y: Int -> x + y }
val action = { print(42) }
*/

val sum: (Int, Int) -> Int = {x, y -> x + y}
val action: () -> Unit = { print(42) }

// 반환 값이 nullable
val canReturnNull: (Int, Int) -> Int? = { x, y -> null }
// 함수타입 자체가 nullable
val funOrNull: ((Int, Int) -> Int)? = null

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        // 전달 받은 함수 실행
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}

fun processTheAnswer(f: (Int) -> Int) {
    println(f(42))
}

fun main(args: Array<String>) {
    twoAndThree {a, b -> a + b}
    twoAndThree {a, b -> a * b}

    println("ab1c".filter { it in 'a'..'z' })

    processTheAnswer { number -> number + 1 }
}
