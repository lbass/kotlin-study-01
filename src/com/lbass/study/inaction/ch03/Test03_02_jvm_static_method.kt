@file:JvmName("StringFunctions")
package com.lbass.study.inaction.ch03

import java.lang.StringBuilder

fun<T> joinToStringTest (
    collection: Collection<T>,
    separator: String = ",",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun main (args: Array<String>) {
    val result = joinToStringTest(listOf("1", "2", "3", "4"), "|", "[", "]")
    println(result)
}
