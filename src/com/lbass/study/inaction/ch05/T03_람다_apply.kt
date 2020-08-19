package com.lbass.study.inaction.ch05

import java.lang.StringBuilder

/**
 * apply 함수는 객체의 인스턴스를 만들면서 즉시 프로퍼티 중 일부를 초기화해야 하는 경우에 유용하다.
 */
fun printAlphabet() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        this.append(letter)
    }
    this.append("\nTEST")
}.toString()

/**
 * 참고용 안드로이드 코드
 * 객체를 생성과 동시에 초기화
 */
/*
fun createViewWithCustomAttributes(context: ConText) =
    TextView(context).apply {
        text = "Sample Text"
        textSize = 20.0
        setPadding(10, 0, 0, 0)
    }
*/

fun printRe01Alphabet() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nTEST")
}

fun main (args: Array<String>) {
    print(printAlphabet())
    print(printRe01Alphabet())
}