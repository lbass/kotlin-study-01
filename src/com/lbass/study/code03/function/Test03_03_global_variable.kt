package com.lbass.study.code03.function

var opCount = 0
const val NAME = "kdw"

fun performOperation() {
    opCount++
}

fun reportOperation () {
    println("$NAME executed perform-operation $opCount times")
}

fun main(args: Array<String>) {
    val loopCount = 4
    var index = 0
    while (index < loopCount) {
        index++
        performOperation()
    }
    reportOperation()
}