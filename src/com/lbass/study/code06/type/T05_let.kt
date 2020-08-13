package com.lbass.study.code06.type

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

fun main(args: Array<String>) {
    val targetEmail01 = "kdw@toss.im"
    val targetEmail02: String? = "kdw@toss.im"
    sendEmailTo("kdw@toss.im")
    // nullable 체크 후 null 이 아닐경우에만 실행
    targetEmail02?.let { sendEmailTo(it) }
}