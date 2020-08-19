package com.lbass.study.refactoring.ch01.step2

import com.lbass.study.refactoring.ch01.Invoice
import com.lbass.study.refactoring.ch01.Performance
import com.lbass.study.refactoring.ch01.Play
import kotlin.math.floor
import kotlin.math.max

data class StatementData (
        val customer: String = "",
        val performances: List<Performance> = emptyList()) {

    var totalAmount: Int = 0
        private set
    private var totalVolumeCredits: Double = 0.0

    fun getTotalVolumeCredits() = this.totalVolumeCredits.toInt()

    fun applyTotalAmount(totalAmount: Int) {
        this.totalAmount = totalAmount
    }

    fun applyTotalVolumeCredits(totalVolumeCredits: Double) {
        this.totalVolumeCredits = totalVolumeCredits
    }
}

private fun amountFor(aPerformance: Performance): Int {
    var result = 0
    when (Play.valueByName(aPerformance.playID).type) {
        "tragedy" -> {
            result = 40_000
            if (aPerformance.audience > 30) {
                result += 1000 * (aPerformance.audience - 30)
            }
        }
        "comedy" -> {
            result = 30_000
            if (aPerformance.audience > 20) {
                result += 10000 + 500 * (aPerformance.audience - 20)
            }
            result += 300 * aPerformance.audience
        }
        else -> throw Exception("알 수 없는 장르: ${Play.valueByName(aPerformance.playID).type}")
    }
    return result
}

private fun volumeCreditsFor(performance: Performance): Double {
    var result = 0.0
    result += max(performance.audience - 30, 0).toDouble()
    if ("comedy" == Play.valueByName(performance.playID).type) result += floor((performance.audience / 5).toDouble())
    return result
}

private fun enrichPerformance(aPerformance: Performance): Performance {
    aPerformance.applyAmount(amountFor(aPerformance))
    aPerformance.applyVolumeCredit(volumeCreditsFor(aPerformance))
    return aPerformance
}

private fun totalAmount(data: StatementData): Int {
    return data.performances.sumBy { it.amount }
}

private fun totalVolumeCredits(data: StatementData): Double {
    return data.performances.sumByDouble { it.volumeCredit }
}

fun createStatementData(invoice: Invoice): StatementData {
    val enrichPerformances: List<Performance> = invoice.performances.map { enrichPerformance(it) }
    val result = StatementData(invoice.customer, enrichPerformances)
    result.applyTotalAmount(totalAmount(result))
    result.applyTotalVolumeCredits(totalVolumeCredits(result))
    return result
}
