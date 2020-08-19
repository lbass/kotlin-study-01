package com.lbass.study.inaction.ch03

import java.lang.StringBuilder

class NotString (message: String)

fun <T> Collection<T>.joinToString(
    separator: String = ",",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append((separator))
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun Collection<String>.joinToStringForString(
    separator: String = ",",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append((separator))
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun main(args: Array<String>) {
    println(listOf(NotString("KDW"), NotString("LBASS")).joinToString(
        separator = ",",
        prefix = "[",
        postfix = "]"
    ))

    println(listOf("KDW", "LBASS").joinToString(
        separator = ",",
        prefix = "[",
        postfix = "]"
    ))

    /**
     * 확장함수의 타입을 지정하면 해당 타입만 허용한다.
     */
    /*
    호출 불가
    println(listOf(NotString("KDW"), NotString("LBASS")).joinToStringForString(
        separator = ",",
        prefix = "[",
        postfix = "]"
    ))
     */

    println(listOf("KDW", "LBASS").joinToStringForString(
        separator = ",",
        prefix = "[",
        postfix = "]"
    ))
}
