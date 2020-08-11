package com.lbass.study.code04.clazz

import java.io.Serializable

interface State: Serializable

/**
 * 중첩 클래스
 *  - 외부 클래스에 대한 참조를 저장하지 않음
 *  - 기본적으로 중첩 클래스임
 * 내부 클래스
 *  - 외부 클래스에 대한 참조를 저장함
 *  - inner 키워드를 붙여야함
 */

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class Button03: View {
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) { }
    class ButtonState: State { }
}