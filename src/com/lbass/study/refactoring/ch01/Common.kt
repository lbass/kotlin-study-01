package com.lbass.study.refactoring.ch01

import com.lbass.study.refactoring.ch01.step2.createStatementData
import com.lbass.study.refactoring.ch01.step2.htmlStatement
import com.lbass.study.refactoring.ch01.step2.renderPlainText
import com.lbass.study.refactoring.ch01.step2.statement as step2Statement

import com.lbass.study.refactoring.ch01.step3.createStatementData as step3StatementData

data class Performance(val playID: String = "", val audience: Int = 0) {
    @Deprecated("step03 에서 사용처에서 매개변수를 받는 형태로 리팩토링", ReplaceWith("nothing"))
    var play: Play = Play.YET
        private set
    var amount: Int = 0
        private set
    var volumeCredit: Double = 0.0
        private set

    @Deprecated("step03 에서 사용처에서 매개변수를 받는 형태로 리팩토링", ReplaceWith("nothing"))
    fun applyPlay(play: Play): Unit {
        this.play = play
    }

    fun applyAmount(amount: Int): Unit {
        this.amount = amount
    }

    fun applyVolumeCredit(volumeCredit: Double) {
        this.volumeCredit = volumeCredit
    }
}
data class Invoice(val customer: String = "", val performances: List<Performance> = emptyList())

enum class Play(val playName: String = "", val type: String = "") {
    YET,
    HAMLET("Hamlet", "tragedy"),
    AS_LIKE("As You Like It", "comedy"),
    OTHELLO("Othello", "tragedy");

    companion object {
        fun valueByName(name: String): Play {
            for(play in values()) {
                if (play.name.contentEquals(name)) {
                    return play
                }
            }
            return YET
        }
    }
}

val performances = listOf(
        Performance("HAMLET", 55),
        Performance("AS_LIKE", 35),
        Performance("OTHELLO", 40)
)

val invoices = listOf(Invoice("BigCo", performances))


fun main(args: Array<String>) {
    // println(statement(Invoice("BigCo", performances), plays))
    // println(step1Statement(Invoice("BigCo", performances), plays))
    println(step2Statement(Invoice("BigCo", performances)))
    println(htmlStatement(Invoice("BigCo", performances)))
}