package com.lbass.study.code08

/**
 * non-local return
 */
fun lookForAlice1(): String {
    listOf("1", "2", "3").forEach {
        if (it == "1") return it
    }
    return ""
}

/**
 * local return
 */
fun lookForAlice2(): String {
    listOf("1", "2", "3").forEach(fun(value) {
        if (value == "1") return
    })
    return ""
}

fun main (args: Array<String>) {
    println("1, ${lookForAlice1()}")
    println("2, ${lookForAlice2()}")
}