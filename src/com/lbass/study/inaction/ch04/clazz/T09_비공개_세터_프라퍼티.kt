package com.lbass.study.inaction.ch04.clazz

class LengthCounter {
    var counter: Int = 0
        private set
    fun addWord(word: String) {
        counter += word.length
    }
}

fun main(args: Array<String>) {
    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
    println(lengthCounter.counter)

    listOf("Kimdowon", "lbass", "done").forEach { s: String -> lengthCounter.addWord(s) }

    println(lengthCounter.counter)
}