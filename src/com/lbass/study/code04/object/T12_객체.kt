package com.lbass.study.code04.`object`

import com.lbass.study.kotlin.Person
import java.io.File
import java.util.Comparator

object Payroll {
    private val allEmployees = arrayListOf<Person>()
    fun calculateSalary() {
        for (person in allEmployees) {
        }
    }
}

object CaseInsensitiveFileComparator: Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

fun main(args: Array<String>) {
    println(CaseInsensitiveFileComparator.compare(File("/Users"), File("/Users")))
    val files = listOf(File("/z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))

    val persons = listOf(Person("kdw", 40), Person("ls", 35) , Person("isole", 3))
    println(persons.sortedWith(Person.NameComparator).reversed())
    println(persons.sortedWith(Person.AgeComparator))
}