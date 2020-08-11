package com.lbass.study.code04.clazz

interface Clickable {
    fun click()
    fun showOff()= println("I'm clickable!")
}

class Button: Clickable {
    override fun click() = println("I was clicked")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus")
    fun showOff() = println("I'm focusable!")
}

class Button02: Clickable, Focusable {
    override fun click() = println("I was clicked")
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

/**
 * 코틀린은 자바 6와 호환되게 설계되었다.
 * 따라서 디폴트 메소드 구현이 정적 메소드로 들어있는 클래스를 조합해 구현한다.
 * 인터페이스에는 메소드 선언만 들어가며, 인터페이스와 함께 생성되는 클래스에는 모든 디폴트 메소드 구현이 정적 메소드로 들어간다.
 */

fun main(args: Array<String>) {
    Button().click()
    Button02().showOff()
    Button02().setFocus(true)
    Button02().click()
}