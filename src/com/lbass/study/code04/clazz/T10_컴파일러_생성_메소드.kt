package com.lbass.study.code04.clazz

class Client (val name: String, val postalCode: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client)
        return false
        return name == other.name &&
                postalCode == other.postalCode
    }
    override fun toString(): String = "Client(name=$name, postalCode=$postalCode)"
    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
}

/**
 * equals 가 정상적으로 동작하기 위해서는 hashCode 가 존재해야 한다.
 */

fun main(args: Array<String>) {
    /**
     * HashSet 은 원소를 비교할 때 비용을 줄이기 위해 먼저 객체의 해시 코드를 비교하고 해시 코드가 같을 경우에만 값을 비교한다.
     * 따라서 반드시 hashCode 를 override 해야한다.
     */
    val processed = hashSetOf(Client01("오현석", 4122))
    println(processed.contains(Client01("오현석", 4122)))

    val lee = Client01("이계영", 4122)
    println(lee.copy())
    println(lee.copy(postalCode = 4000))

    val processed2 = hashSetOf(lee)
    println(processed2.contains(Client01("이계영", 4121)))
}

data class Client01(val name: String, val postalCode: Int)
