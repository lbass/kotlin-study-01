package com.lbass.study.inaction.ch02

import java.lang.IllegalArgumentException

interface Expr

class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) :
    Expr

fun main(args: Array<String>) {
    println(
        eval(
            Sum(
                Sum(
                    Num(1),
                    Num(2)
                ), Num(4)
            )
        )
    )
    println(
        eval1(
            Sum(
                Sum(
                    Num(1),
                    Num(2)
                ), Num(4)
            )
        )
    )
    println(
        eval2(
            Sum(
                Sum(
                    Num(1),
                    Num(2)
                ), Num(4)
            )
        )
    )
    println(
        evalWithLogging(
            Sum(
                Sum(
                    Num(1),
                    Num(2)
                ), Num(4)
            )
        )
    )
}

fun eval(e: Expr): Int {
    if (e is Num) {
        return e.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun eval1(e: Expr): Int =
    if (e is Num) {
        e.value
    } else if (e is Sum) {
        eval1(e.right) + eval1(e.left)
    } else {
        throw IllegalArgumentException("Unknown expression")
    }

fun eval2(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval2(e.right) + eval2(
            e.left
        )
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.right)
            val right = evalWithLogging(e.left)
            println("sum: $left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }