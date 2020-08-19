package com.lbass.study.refactoring.ch01.step3

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

interface PerformanceCalculator {
    fun amount(): Int
    fun volumeCredits(): Double
}

class TragedyCalculator(private val performance: Performance = Performance()): PerformanceCalculator {
    override fun amount(): Int {
        var result = 40_000
        if (this.performance.audience > 30) {
            result += 1000 * (this.performance.audience - 30)
        }
        return result
    }

    override fun volumeCredits(): Double {
        return max(this.performance.audience - 30, 0).toDouble()
    }
}

class ComedyCalculator(private val performance: Performance = Performance()): PerformanceCalculator {
    override fun amount(): Int {
        var result = 30_000
        if (this.performance.audience > 20) {
            result += 10000 + 500 * (this.performance.audience - 20)
        }
        result += 300 * this.performance.audience
        return result
    }

    override fun volumeCredits(): Double {
        return max(this.performance.audience - 30, 0).toDouble() + floor((this.performance.audience / 5).toDouble())
    }
}

/**
 * 리팩토링 대상 메소드
 */
private fun enrichPerformance(aPerformance: Performance): Performance {
    val calculator = createPerformanceCalculator(aPerformance)
    aPerformance.applyAmount(calculator.amount())
    aPerformance.applyVolumeCredit(calculator.volumeCredits())
    return aPerformance
}

private fun totalAmount(data: StatementData): Int {
    return data.performances.sumBy { it.amount }
}

private fun totalVolumeCredits(data: StatementData): Double {
    return data.performances.sumByDouble { it.volumeCredit }
}

fun createPerformanceCalculator(aPerformance: Performance): PerformanceCalculator =
    when (Play.valueByName(aPerformance.playID).type) {
        "tragedy" -> TragedyCalculator(aPerformance)
        "comedy" -> ComedyCalculator(aPerformance)
        else -> throw Exception("오류")
    }

fun createStatementData(invoice: Invoice): StatementData {
    val enrichPerformances: List<Performance> = invoice.performances.map { enrichPerformance(it) }
    val result = StatementData(invoice.customer, enrichPerformances)
    result.applyTotalAmount(totalAmount(result))
    result.applyTotalVolumeCredits(totalVolumeCredits(result))
    return result
}
