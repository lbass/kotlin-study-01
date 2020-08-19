package com.lbass.study.inaction.ch08

enum class Delivery { STANDARD, EXPEDITED }

class Order(val itemCount: Int)

/**
 * 다른 계산 함수를 전달하는 함수를 저의
 */
fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
    if(delivery == Delivery.EXPEDITED) {
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return { order -> 1.2 * order.itemCount }
}
data class Person (
        val firstName: String,
        val lastName: String,
        val phoneNumber: String?
)

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate(): (Person) -> Boolean {
        val startsWithPrefix: (Person) -> Boolean = { p: Person ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }
        if (!onlyWithPhoneNumber) {
            return startsWithPrefix
        }
        return { startsWithPrefix(it)
                && it.phoneNumber != null }
    }
}


fun main(args: Array<String>) {
    val calculator = getShippingCostCalculator(Delivery.STANDARD)
    println("Shipping costs ${calculator(Order(3))}")
    println("Shipping costs ${getShippingCostCalculator(Delivery.EXPEDITED)(Order(3))}")

    val contacts = listOf(Person("Dmitry", "Jemerov", "123-4567"),
           Person("Svetlana", "Isakova", null))

    val contactListFilters = ContactListFilters()
    // 초기화 구문
    with(contactListFilters) {
        prefix = ""
        onlyWithPhoneNumber = true
    }
    println(contacts.filter(contactListFilters.getPredicate()))
}