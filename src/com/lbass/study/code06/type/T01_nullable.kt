package com.lbass.study.code06.type

fun strLen(s : String) = s.length

/**
 * 변수 타입뒤의 ? 표시는 null 의 가능성을 보여준다.
 */
fun strLenSafe(s : String?) : Int = if (s != null) s.length else 0

fun printAllCaps(s : String?) {
    val allCaps : String? = s?.toUpperCase()
    println(allCaps)

    /**
     * nullable 일 경우 받는 쪽도 nullable 이어야 한다.
     */
    val func = { asd: String? -> asd?.length }
    val length : Int? = func(s)
}

fun main (args : Array<String>) {
    printAllCaps("abc")
    printAllCaps(null)
}