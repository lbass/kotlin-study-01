package com.lbass.study.inaction.ch04.clazz

class UserT08(val name: String) {
    /**
     * field 라는 특별한 식별자를 통해 뒷받침하는 필드에 접근할 수 있다.
     */
    var address: String = "unspecified"
        set(value) {
            println(
                """
            Address was changed for $name:
            "$field" -> "$value".""".trimIndent()
            )
            field = value
        }
}

fun main(args: Array<String>) {
    val user = UserT08("Alice")
    user.address = "Elsenheimerstrasse 47, 80687 Muenchen"
}