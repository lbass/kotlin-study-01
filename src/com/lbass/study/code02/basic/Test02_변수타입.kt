package com.lbass.study.code02.basic

fun main(args: Array<String>) {
    println("Hello, world!")
    println(max(1, 2))
}

fun max(a: Int, b: Int) = if (a > b) a else b

const val answer1 = 42

fun testValAndVar() {
    var answer3: Int = 42
    answer3 = 43

    val question = "삶, 우주, 그리고 모든 것에 대한 궁극적인 질문"
    val answer1 = 42
    val answer2: Int = 42
    val yearsToCompute: Double = 7.5e6
}

