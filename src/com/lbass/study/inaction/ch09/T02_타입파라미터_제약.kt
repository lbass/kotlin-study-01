package com.lbass.study.inaction.ch09

fun <T: Number> oneHalf(value: T): Double {
    return value.toDouble() / 2.0
}

fun main(args: Array<String>) {
    println(oneHalf(3))
}