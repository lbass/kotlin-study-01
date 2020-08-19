package com.lbass.study.inaction.ch08

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

data class SiteVisit (
        val path: String,
        val duration: Double,
        val os: OS
)

val log = listOf(
        SiteVisit("/", 34.0, OS.WINDOWS),
        SiteVisit("/", 22.0, OS.MAC),
        SiteVisit("/login", 12.0, OS.WINDOWS),
        SiteVisit("/signup", 8.0, OS.IOS),
        SiteVisit("/", 16.3, OS.ANDROID)
)

/**
 * 하드 코딩한 필터
 */
val averageWindowsDuration = log
    .filter { it.os == OS.WINDOWS }
    .map(SiteVisit::duration)
    .average()

/**
 * 일반 함수을 통해 중복 제거
 */
inline fun List<SiteVisit>.averageDurationFor(os: OS) = filter { it.os == os }
    .map(SiteVisit::duration).average()

/**
 * 복잡하게 하드코딩한 필터를 사용해 방문 데이터 분석하기
 */
val averageMobileDuration = log
    .filter { it.os in setOf(OS.IOS, OS.ANDROID) }
    .map(SiteVisit::duration)
    .average()

/**
 * 고차 함수를 사용해 중복 제거하기
 */
inline fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
    filter(predicate).map(SiteVisit::duration).average()

fun main(args: Array<String>) {
    println("하드 코딩한 필터: $averageWindowsDuration")
    println("일반 함수을 통해 중복 제거: ${log.averageDurationFor(OS.ANDROID)}")
    println("하드코딩한 필터를 사용해 방문 데이터 분석: $averageMobileDuration")

    println("고차 함수를 사용해 중복 제거: ${log.averageDurationFor {
        it.os == OS.IOS && it.path == "/signup"
    }}")

    // 시퀀스를 통해 성능을 향상시킬 수 있는 경우는 컬렉션의 크기가 큰 경우 뿐이다.
}