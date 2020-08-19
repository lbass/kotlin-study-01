package com.lbass.study.refactoring.ch01.step2

import com.lbass.study.refactoring.ch01.Invoice
import java.text.NumberFormat
import java.util.*

// statement 함수...
fun usd(aNumber: Int): String =  NumberFormat.getCurrencyInstance(Locale("en", "US")).format(aNumber / 100)

fun statement(invoice: Invoice): String {
    return renderPlainText(createStatementData(invoice))
}

fun renderPlainText(data: StatementData): String {
    var result = "청구 내역 (고객명: ${data.customer})\n"
    for (performance in data.performances) {
        result += " ${performance.play.name}: ${usd(performance.amount)} (${performance.audience}석)\n"
    }
    result += "총액: ${usd(data.totalAmount)}\n"
    result += "적립 포인트: ${data.getTotalVolumeCredits()}점\n"
    return result
}

fun htmlStatement(invoice: Invoice): String {
    return renderHtml(createStatementData(invoice))
}

fun renderHtml(data: StatementData): String {
    var result = """
        <h1>청구 내역 (고객명:${data.customer})</h1>
        <table>
        <tr><th>연극</th><th>좌석 수</th><th>금액</th></tr>
    """.trimIndent()
    for (performance in data.performances) {
        result += "<tr><td>${performance.play.name}</td><td>${usd(performance.amount)}</td><td>(${performance.audience}석)</td></tr>\n"
    }
    result += "<p>총액: <em>${usd(data.totalAmount)}</em></p>\n"
    result += "<p>적립 포인트: <em>${data.getTotalVolumeCredits()}</em>점</p>\n"
    return result
}

