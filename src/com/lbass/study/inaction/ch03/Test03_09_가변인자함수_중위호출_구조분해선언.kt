package com.lbass.study.inaction.ch03

// 중위 호출 -> infix
infix fun String.checkLength(length: Int): Boolean = this.length == length

fun main(args: Array<String>) {
    val argsList = arrayOf("arg1", "arg2", "arg3")
    /**
     * 가변인자의 경우 스프레드 연산자 (*) 가 배열을 풀어준다. (배열객체 자체를 받지 않고 원소들을 대입할 수 있도록 펼쳐줌)
     */
    val list: List<String> = listOf("args", *argsList)
    println(list)

    // 중위 호출
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    val map2 = mapOf(1.to("one"), 7.to("seven"), 53.to("fifty-three"))

    println(map)
    println(map2)
    println("내가몇글자" checkLength 5)

    // 구조 분해 선언 (자바스트립트에서 object 꺼내 오는 것과 유사함)
    val (number, name) = 1 to "one"
    for ((index, element) in list.withIndex()) {
        println("#$index : $element")
    }

}