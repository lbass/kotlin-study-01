package com.lbass.study.inaction.ch04.clazz

open class RichButton : Clickable {
    fun disable() {}

    open fun animate() {}

    // final 을 붙이지 않을 경우 override 메소드나 프라퍼티는 기본적으로 열려있다.
    final override fun click() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

abstract class Animated {
    abstract fun animate()
    open fun stopAnimating() {

    }
    fun animateTwice() {

    }
}