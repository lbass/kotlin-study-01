package com.lbass.study.code06.type

import java.lang.IllegalArgumentException

/**
 * 안전한 호출 연쇄시키기
 */
class Address(val streetAddress: String, val zipCode: Int,
              val city: String, val country: String)
class Company(val name: String, val address: Address?)
class Person(val name: String, val company: Company?) {
    fun countryName(): String {
        /**
         * nullable 체크 후 null 일 경우 default 값 처리 [ ?: "" ] = 엘비스(elvis) 연산자
         * ? 를 시계방향으로 90도 돌리면 엘비스의 헤어스타일과 눈이 보인다. ㅋㅋ
         */
        return company?.address?.country ?: "Unknown"
    }
}

// 엘비스 연산자
fun strLengthSafe(s: String?): Int = s?.length ?: 0

fun printShippingLabel(person: Person) {
    // 예외를 던지는 것도 가능하다.
    val address = person.company?.address?: throw IllegalArgumentException("No address")
    with(address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

fun main(args: Array<String>) {
    println(strLengthSafe("abc"))

    val person = Person("김도원", Company("Toss", Address("역삼로", 123123, "서울", "한국")))
    println(person.countryName())
    printShippingLabel(person)

    val personWithError = Person("김이솔", null)
    printShippingLabel(personWithError)
}