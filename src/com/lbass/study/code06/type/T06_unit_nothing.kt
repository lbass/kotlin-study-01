package com.lbass.study.code06.type

interface Processor<T> {
    fun process(): T
}


/**
 * Processor.process 메소드 시그네쳐에 따라 타입을 반환해야 하지만
 * generic 타입을 Unit 으로 지정할 경에는 return 을 생략해도 된다.
 */
class NoResultProcessor: Processor<Unit> {
    override fun process() {

    }
}

/*
process 메소드에서 리턴값이 없으므로 컴파일 오류가 발생한다.
class PersonProcessor: Processor<Person> {
    override fun process() {

    }
}
 */

fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}

fun main(args: Array<String>) {
    val company = Company(name="토스", address = null)
    // Nothing 을 반환하는 함수일 경우 로직 진행이 되지 않을음 컴파일러가 알게된다.
    val address = company.address ?: fail("error")
    // 이로 인해 nullable 인 company.address 를 !! 확인 없이 접근할 수 있게 된다.
    println(company.address.city)
    fail("error")
}