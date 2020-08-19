package com.lbass.study.inaction.ch04.`object`

val facebookUsers:Map<Int, String>  = mapOf(Pair(1, "kdw"), Pair(2, "ls"), Pair(3, "isole"))

fun getFacebookName(accountId: Int): String {
    return facebookUsers.getOrDefault(accountId, "")
}

class User private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) =
            User(email.substringBefore('@'))
        fun newFacebookUser(accountId: Int) =
            User(getFacebookName(
                    accountId))
    }
}

fun main(args: Array<String>) {
    val subscribingUser =
        User.newSubscribingUser("kdw@toss.im")
    val facebookUser = User.newFacebookUser(2)
    println(subscribingUser.nickname)
    println(facebookUser.nickname)
}