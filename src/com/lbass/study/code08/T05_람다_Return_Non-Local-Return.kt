package com.lbass.study.code08

data class Human(val name: String, val age: Int)

val humans = listOf(Human("Alice", 29), Human("Bob", 31))

fun lookForAlice(humans: List<Human>): String {
    for(human in humans) {
        if (human.name == "Alice") {
            return "find it!"
        }
    }
    return "not found"
}

fun lookForAliceByLambda(humans: List<Human>): String {
    humans.forEach {
        if (it.name == "Alice") {
            // lookForAliceByLambda 함수의 리턴 값이 된다. non local-return
            return "find it!"
        }
    }
    return "not found"
}

/**
 * local return
 */
fun lookForAliceByLabel1(humans: List<Human>): String {
    humans.forEach label@ {
        if (it.name == "Alice") {
            // lookForAliceByLambda 함수의 리턴 값이 된다. non local-return
            return@label
        }
    }
    return "not found"
}

/**
 * non-local return
 */
fun lookForAliceByLabel2(humans: List<Human>): String {
    humans.forEach label@ {
        if (it.name == "Alice") {
            // lookForAliceByLambda 함수의 리턴 값이 된다. non local-return
            return@label
        }
    }
    return "not found"
}

/**
 * 함수이름을 return 레이블로 사용 가능하다.
 */
fun lookForAliceByLabel3(humans: List<Human>): String {
    humans.forEach {
        if (it.name == "Alice") {
            // lookForAliceByLambda 함수의 리턴 값이 된다. non local-return
            return@forEach
        }
    }
    return "not found"
}

/**
 * 레이블이 붙은 this 식
 */
val labelThis = {
    println(StringBuilder().apply sb@ {
        listOf(1, 2, 3).apply {
            this@sb.append(this.toString())
        }
    })
}


fun main(args: Array<String>) {
    println(lookForAlice(humans))
    println(lookForAliceByLambda(humans))
    labelThis()
}