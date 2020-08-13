package com.lbass.study.code06.type

fun main(args: Array<String>) {
    // immutable
    val employees1: List<TossEmployee> = listOf(TossEmployee("김", "도원"))
    // add 에 접근 할 수 없다.
    // employees1.add()

    // mutableList
    val employees2: MutableList<TossEmployee> = mutableListOf(TossEmployee("김", "도원"))
    employees2.add(TossEmployee("양", "권성"))
}