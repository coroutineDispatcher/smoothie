package com.sxhardha.smoothie

object Smoothie {
    private const val RESOURCE = "SMOOTHIE"

    @JvmField
    val countingIdlingResource = SmoothieThermometer(RESOURCE)

    fun increment() {
        countingIdlingResource.startProcess()
    }

    fun decrement() {
        if (!countingIdlingResource.isIdleNow) {
            countingIdlingResource.endProcess()
        }
    }
}