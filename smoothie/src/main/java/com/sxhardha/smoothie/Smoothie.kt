package com.sxhardha.smoothie

object Smoothie {
    private const val RESOURCE = "SMOOTHIE"

    @JvmField
    val countingIdlingResource = SmoothieThermometer(RESOURCE)

    fun increment() {
        countingIdlingResource.increment()
    }

    fun decrement() {
        if (!countingIdlingResource.isIdleNow) {
            countingIdlingResource.decrement()
        }
    }
}