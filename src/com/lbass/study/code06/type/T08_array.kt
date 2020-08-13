package com.lbass.study.code06.type

fun main(args: Array<String>) {
    // 사이즈로 선언하여 배열을 만들때는 생성자가 필요함
    val strings = Array<String>(30) {
        i -> ('a' + i).toString()
    }

    println(strings.joinToString(", "))
}