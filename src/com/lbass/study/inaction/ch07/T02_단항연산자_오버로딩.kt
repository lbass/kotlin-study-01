package com.lbass.study.inaction.ch07

operator fun Point.unaryMinus(): Point {
    return Point(-value)
}

// 증가연산자
operator fun Point.inc(): Point {
    return Point(value + 1)
}

operator fun Point.dec(): Point {
    return Point(value - 1)
}

fun main(args: Array<String>) {
    val p = Point(10)
    println(-p)

    // 증가연산자는 스스로 값이 증가하므로 var 를 사용해야 한다.
    var p2 = Point(10)
    ++p2
    println(p2)
    p2++
    println(p2)
    --p2
    println(p2)
    p2--
    println(p2)
}