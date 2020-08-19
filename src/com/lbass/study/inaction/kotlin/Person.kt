package com.lbass.study.inaction.kotlin

data class Person(
    val name: String,
    val age: Int
) {
    val doubleAge: Int
        get() = age * 2

    object NameComparator: Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int = p1.name.compareTo(p2.name)
    }

    object AgeComparator: Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int = p1.age.compareTo(p2.age)
    }
}