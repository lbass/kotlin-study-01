package com.lbass.study.code06.type

fun ignoreNulls(s: String?) {
    val sNotNull: String = s!!
    println(sNotNull.length)
}

// 안티패턴 (오류 시 라인으로 분석이 힘들어 진다.)
fun Person.notNullAssertionAntiPattern(): String = company!!.address!!.country

fun Person.notNullAssertion(): String {
    company!!
    company.address!!
    return company.address.country
}

fun main (args: Array<String>) {
    ignoreNulls("널 이면 오류")
    val person = Person("김도원", Company("Toss", Address("역삼로", 123123, "서울", "한국")))
    println(person.notNullAssertion())
    val person2 = Person("김도원", Company("Toss", null))
    try {
        println(person2.notNullAssertion())
    } catch (e: Exception) {
        e.printStackTrace()
    }
    try {
        println(person2.notNullAssertionAntiPattern())
    } catch (e: Exception) {
        e.printStackTrace()
    }
}