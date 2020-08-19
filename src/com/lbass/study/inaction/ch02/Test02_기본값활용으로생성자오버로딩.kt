package com.lbass.study.inaction.ch02

fun main(args: Array<String>) {
    val p1 = com.lbass.study.inaction.java.Person("do-won");
    val p2 = com.lbass.study.inaction.kotlin.Person("do-won", 23);

    println("${p1.name}")
    println("${p2.name}, ${p2.age}, ${p2.doubleAge}")
}