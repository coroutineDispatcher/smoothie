package com.sxhardha.smoothie

import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test


class SmoothieThermometerTest {

    private val resourceName: String = "SMOOTHIE"

    private lateinit var smoothieThermometer: SmoothieThermometer

    @Before
    fun setUp() {
        smoothieThermometer = SmoothieThermometer(resourceName)
    }

    @After
    fun tearDown() {
        print("Finished Testing")
    }

    @Test
    fun `getName method should return given resource name`() {
        assertEquals(resourceName, smoothieThermometer.name)
    }

    @Test
    fun `getName method should be wrong given other resource name`() {
        assertNotEquals("SomeStrangeResourceName", smoothieThermometer.name)
    }

    @Test
    fun `increment method should return false on isIdleNow`() {
        smoothieThermometer.startProcess()
        assertEquals(false, smoothieThermometer.isIdleNow)
    }

    @Test(expected = IllegalStateException::class)
    fun `decrement method should throw error`() {
        smoothieThermometer.endProcess()
    }

    @Test
    fun `decrement method should return true on isIdleNow`() {
        smoothieThermometer.startProcess()

        assertEquals(false, smoothieThermometer.isIdleNow)

        smoothieThermometer.endProcess()

        assertEquals(true, smoothieThermometer.isIdleNow)
    }
}