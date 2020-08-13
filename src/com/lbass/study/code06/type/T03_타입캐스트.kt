package com.lbass.study.code06.type

class TossEmployee(val firstName: String, val lastName: String) {
    override fun equals(o: Any?): Boolean {
        // 안전한 캐스트 => as?
        val otherEmployee = o as? TossEmployee ?: return false
        return otherEmployee.firstName == firstName &&
                otherEmployee.lastName == lastName
    }

    override fun hashCode(): Int = firstName.hashCode() * 37 + lastName.hashCode()
}

fun main (args: Array<String>) {
    val e1 = TossEmployee("김", "도원")
    val e2 = TossEmployee("김", "도원")

    println(e1 == e2)
    println(e1.equals(42))
}