package com.lbass.study.inaction.ch08

import java.lang.StringBuilder

/**
 * 함수 기본값 설정
 */
fun<T> joinToString (
        collection: Collection<T>,
        separator: String = ",",
        prefix: String = "",
        postfix: String = "",
        transform: (T) -> String = { it.toString() }
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(transform(element))
    }
    result.append(postfix)
    return result.toString()
}

/**
 * nullable 함수 파라메터 실행 방법
 */
fun<T> testNullableFun (
        element: T,
        transform: ((T) -> String)? = null
): String {
    return transform?.invoke(element) ?: element.toString()
}

fun main(args: Array<String>) {
    println(joinToString(listOf(arrayOf("A","B","C"), arrayOf("D","E","F"))))
    // 좀더 가독성이 좋다.
    println(joinToString(listOf(arrayOf("A","B","C"), arrayOf("D","E","F"))) {
        it.joinToString(separator = ",")
    })
    // 인라인으로 배치했을 경우 가독성이 떨어짐
    println(joinToString(listOf(arrayOf("A","B","C"), arrayOf("D","E","F")), transform = {
        it.joinToString(separator = ",")
    }))

    println(testNullableFun("String"))
}