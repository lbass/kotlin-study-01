package com.lbass.study.code03.function

open class View {
    open fun click() = println("View clicked")
}
fun View.showOff() = println("I'm a view!")

class Button: View() {
    override fun click() = println("Button clicked")
}
fun Button.showOff() = println("I'm a button!")

/**
 * 실행시점에 객체 타입에 따라 동적으로 호출될 대상 메소드를 결정하는 방식을 동적 디스패치라고 한다.
 * 컴파일 시점에 알려진 변수 타입에 따라 정해진 메소드를 호출하는 방식은 정적 디스패치라고 부른다.
 * 검파일 시점은 '정적', '동적' 이라는 말은 실행 시점을 의미한다.
 */
fun main(args: Array<String>) {
    val obj01: Button = Button()
    val obj02: View = Button()
    val obj03: View = View()

    obj01.click()
    obj01.showOff()
    obj02.click()
    /**
     * 확장함수는 정적으로 결정된다. (실제 생성된 객체가의 showOff 가 실행되는 것이 아니라 선언된 타입의 showOff 가 실행
     * 확장함수는 오버라이드 할 수 없다.
     */
    obj02.showOff()
    obj03.click()
    obj03.showOff()
}