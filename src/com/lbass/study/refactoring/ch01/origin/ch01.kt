package com.lbass.study.refactoring.ch01.origin

import com.lbass.study.refactoring.ch01.Invoice
import com.lbass.study.refactoring.ch01.Play
import java.text.NumberFormat
import java.util.*
import kotlin.math.floor
import kotlin.math.max


fun statement(invoice: Invoice, plays:Map<String, Play>): String {
    var totalAmount = 0
    var volumeCredits = 0.0
    var result: String = "청구 내역 (고객명: ${invoice.customer})\n"

    val format = NumberFormat.getCurrencyInstance(Locale("en", "US"))

    for (performance in invoice.performances) {
        val play: Play = Play.valueByName(performance.playID)
        var thisAmount = 0

        when(play.type) {
            "tragedy" -> {
                thisAmount = 40_000
                if (performance.audience > 30) {
                    thisAmount += 1000 * (performance.audience - 30)
                }
            }
            "comedy" -> {
                thisAmount = 30_000
                if (performance.audience > 20) {
                    thisAmount += 10000 + 500 * (performance.audience - 20)
                }
                thisAmount += 300 * performance.audience
            }
            else -> throw Exception("Dirty color")
        }

        volumeCredits += max(performance.audience - 30, 0).toDouble()
        if ("comedy" == play.type) volumeCredits += floor((performance.audience / 5).toDouble())

        result += " ${play.name}: ${format.format(thisAmount / 100)} (${performance.audience}석)\n"
        totalAmount += thisAmount
    }
    result += "총액: ${format.format(totalAmount/100)}\n"
    result += "적립 포인트: ${volumeCredits.toInt()}점\n"
    return result
}