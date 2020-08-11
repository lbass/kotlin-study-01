package com.lbass.study.code04.clazz

/**
 * sealed 클래스에 속한 값에 대해 디폴트 분기를 사용하지 않고 when 식을 사용하면
 * 나중에 sealed 클래스의 상속 계층에 새로운 하위 클래스를 추가해도 when 식이 컴파일 되지 않는다.
 * 강제로 when 식을 고쳐야한다.
 */
sealed class Expr {
    class Num(val value: Int): Expr()
    class Sum(val left: Expr, val right: Expr): Expr()
    class Minus(val value: Int): Expr()
}

fun eval (e: Expr): Int =
    when (e) {
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.right) + eval(e.left)
        is Expr.Minus -> e.value
    }
