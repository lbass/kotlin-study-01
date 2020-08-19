package com.lbass.study.inaction.ch05

import java.lang.StringBuilder

fun alphabet() : String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }

    result.append("\nNow I know the alphabet!")
    return result.toString()
}

fun re01Alphabet() : String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        /**
         * with 에서 첫번째 인자를 람다의 수신객체로 만든다.
         * stringBuilder = 람다에서의 this
         */
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        append("\nNow I know the alphabet!")
        toString()
    }
    /**
     * = with(stringBuilder, {....}) 같은 표현이지만 가독성이 떨어진다.
     */
}

fun re02Alphabet() = with(StringBuilder()) {
    /**
     * 메소드 이름 충돌이 발생했을 경우 this 를 사용하면 수신객체를 가르킨다
     */
    // this == StringBuilder
    for (letter in 'A'..'Z') {
        this.append(letter)
    }
    this.append("\nNow I know the alphabet!")
    toString()
}

fun main(args: Array<String>) {
    println(alphabet())
    println(re01Alphabet())
    println(re02Alphabet())
}