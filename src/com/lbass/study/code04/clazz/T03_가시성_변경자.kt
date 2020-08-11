package com.lbass.study.code04.clazz

internal class TalkativeButton : Focusable {
    private fun yell() = println("Hey!")
    // 상속을 허용하지 않는 클래스인데 protected 로 선언되어 경고가 표시됨
    protected fun whisper() = println("Let's task!")
}

// 확장 함수는 public 인데 TalkativeButton internal 이므로 가시성이 올바르지 않아 오류 표시
/*
fun TalkativeButton.giveSpeech() {
    yell()
    whisper()
}
 */