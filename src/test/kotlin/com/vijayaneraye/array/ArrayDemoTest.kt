package com.vijayaneraye.array

import org.junit.Assert.assertEquals
import org.junit.Test

class ArrayDemoTest {

    @Test
    fun `check if first index is mon in arrayofWeekDays `() {
        assertEquals("mon", arrayOfWeekDays.get(1))
    }

    @Test
    fun `check if zero index is sun in arrayofWeekDays `() {
        assertEquals("sun", arrayOfWeekDays.get(0))
    }


    @Test
    fun `check empty array of 3 size and add 3 items  `() {
        var emptyArray = emptyArray
        emptyArray.set(0,"Red")
        emptyArray.set(1,"Green")
        emptyArray.set(2,"Yellow")
        assertEquals("Green", emptyArray.get(1))
    }


    @Test(expected = ArrayIndexOutOfBoundsException::class)
    fun `should throw ArrayIndex exception if adding 4 items in array of 3 size and add 3 items  `() {
        var emptyArray = emptyArray
        emptyArray.set(0,"Red")
        emptyArray.set(1,"Green")
        emptyArray.set(2,"Yellow")
        emptyArray.set(4,"Black")
    }
}