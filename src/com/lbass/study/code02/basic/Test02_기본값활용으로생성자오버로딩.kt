package com.lbass.study.code02.basic

fun main(args: Array<String>) {
    val p1 = com.lbass.study.java.Person("do-won");
    val p2 = com.lbass.study.kotlin.Person("do-won", 23);

    println("${p1.name}")
    println("${p2.name}, ${p2.age}, ${p2.doubleAge}")
}