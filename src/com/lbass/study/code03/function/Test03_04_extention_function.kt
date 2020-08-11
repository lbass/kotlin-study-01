package com.lbass.study.code03.function

// String <-- 수신객체타입 (Receiver type)
// this <-- 수신 객체 (Receiver object)
fun String.lastChar(): Char = this[this.length - 1]

// 본문에서 this 삭제 가능함
fun String.firstChar(): Char = get(length - 1)

fun main(args: Array<String>) {
    println("kdw executed lastChar".lastChar())
}
