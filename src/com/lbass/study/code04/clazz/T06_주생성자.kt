package com.lbass.study.code04.clazz

/**
 * 클래스 이름 뒤에 괄호로 둘러싸인 코드를 주 생성자라고 부른다.
 */

class User constructor(_nickname: String) {
    val nickname: String
    init {
        nickname = _nickname
    }
}

class User01(_nickname: String) {
    val nickname = _nickname
}

class User02(val nickname: String)

// 기반 클래스
open class User03(val nickname: String,
             val isSubscribed: Boolean = true)


class TwitterUser(nickname: String): User03(nickname, isSubscribed = false) {}

// 비공개 생성자
class Secretive private constructor() {}

fun main(args: Array<String>) {
    val hyun = User03("현석")
    println(hyun.isSubscribed)

    val gye = User03("계영", false)
    println(gye.isSubscribed)

    val hey = User03("혜원", isSubscribed = false)
    println(hey.isSubscribed)

    val test = TwitterUser("트위터")
    println(test.isSubscribed)

    // 생성불가
    // val secret = Secretive()
}
