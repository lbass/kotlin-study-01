package com.lbass.study.refactoring.ch01.step1

import com.lbass.study.refactoring.ch01.*
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.floor
import kotlin.math.max

// statement 함수...

fun statement(invoice: Invoice, plays:Map<String, Play>): String {
    fun usd(aNumber: Int)  =  NumberFormat.getCurrencyInstance(Locale("en", "US")).format(aNumber / 100)

    fun playFor(performance: Performance) = Play.valueByName(performance.playID)

    fun volumeCreditsFor(performance: Performance): Double {
        var result = 0.0
        result += max(performance.audience - 30, 0).toDouble()
        if ("comedy" == playFor(performance).type) result += floor((performance.audience / 5).toDouble())
        return result
    }

    fun amountFor(aPerformance: Performance): Int {
        var result = 0
        when(playFor(aPerformance).type) {
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
            else -> throw Exception("알 수 없는 장르: ${playFor(aPerformance).type}")
        }
        return result
    }

    fun totalAmount(): Int {
        var result = 0
        for (perf in invoice.performances) {
            result += amountFor(perf)
        }
        return result
    }

    fun totalVolumeCredits(): Double {
        var volumeCredits = 0.0
        for (perf in invoice.performances) {
            volumeCredits += volumeCreditsFor(perf)
        }
        return volumeCredits
    }

    var result: String = "청구 내역 (고객명: ${invoice.customer})\n"
    for (performance in invoice.performances) {
        result += " ${playFor(performance).name}: ${usd(amountFor(performance))} (${performance.audience}석)\n"
    }
    result += "총액: ${usd(totalAmount())}\n"
    result += "적립 포인트: ${totalVolumeCredits().toInt()}점\n"
    return result
}