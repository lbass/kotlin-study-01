package com.lbass.study.inaction.ch04.clazz

import javax.naming.Context
import javax.print.attribute.AttributeSet

open class ViewT07 {
    constructor(ctx: Context) {

    }

    constructor(ctx: Context, attr: AttributeSet)
}

class MyButton : ViewT07 {
    // 이 클래스의 다른 생성자에게 위임한다.
    /*
    constructor(ctx: Context) : this(ctx, MY_STYLE) {
    }
     */

    constructor(ctx: Context, attr: AttributeSet)
            : super(ctx, attr) {

    }
}

interface UserT07 {
    val email: String
    val nickname: String
}

class PrivateUser(override val nickname: String) : UserT07 {
    override val email: String
        get() = nickname
}

class SubscribingUser(override val email: String) : UserT07 {
    override val nickname: String
        get() = email.substringBefore('@')
}

class FaceBookUser(val accountId: Int): UserT07 {
    private val accountEmailMap: Map<Int, String> = mapOf(Pair(1, "kdw@facebook.com"), Pair(2, "kdw@kakao.com"), Pair(3, "kdw@naver.com"))
    override val email: String
        get() = accountEmailMap.getOrDefault(this.accountId, "").substringBefore('@')
    override val nickname: String = getFacebookName()
    private fun getFacebookName(): String = accountEmailMap.getOrDefault(this.accountId, "").substringBefore('@')
}

fun main(args: Array<String>) {
    val privateUser = PrivateUser("김도원")
    val subscribingUser = SubscribingUser(email = "kdw@toss.im")
    val faceBookUser = FaceBookUser(accountId = 1)

    println(privateUser.nickname)
    println("${subscribingUser.nickname}, ${subscribingUser.email}")
    println("${faceBookUser.nickname}, ${faceBookUser.accountId}")
}

