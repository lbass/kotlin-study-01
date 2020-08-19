package com.lbass.study.inaction.ch04.clazz

class DelegatingCollection<T> (
    innerList: Collection<T> = ArrayList<T>()
) : Collection<T> by innerList {}


class CountingSet<T>(
    private val innerSet: MutableCollection<T> = HashSet()
): MutableCollection<T> by innerSet {
    var objectsAdded = 0
        private set
    val countingSize: Int
        get() = innerSet.size + 1

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }
    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)

    }
}

fun main(args: Array<String>) {
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 2))
    print("${cset.objectsAdded} objects were added, ${cset.countingSize} remain")
}