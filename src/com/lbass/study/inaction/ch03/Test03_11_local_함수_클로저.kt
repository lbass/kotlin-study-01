package com.lbass.study.inaction.ch03

import java.lang.IllegalArgumentException

data class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Cant't save user ${user.id} empty Name")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Cant't save user ${user.id} empty Address")
    }
}

fun saveUserLocalFun(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Cant't save user ${user.id} empty $fieldName")
        }
    }

    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
    println(user)
}


fun saveUserLocalClosure(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Cant't save user ${user.id} empty $fieldName")
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")
    println(user)
}

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Cant't save user ${id} empty $fieldName")
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}

fun saveUserWithExtensionFun(user: User) {
    user.validateBeforeSave()
    println(user)
}


fun main(args: Array<String>) {
    saveUserWithExtensionFun(User(1, "kdw", "광진구 구의동"))
    saveUserLocalFun(User(2, "kdw", "광진구 구의동"))
    saveUserLocalClosure(User(3, "", "광진구 구의동"))
    saveUser(User(4, "", ""))
}