package com.vijayaneraye.list

import org.junit.Assert.assertEquals
import org.junit.Test

class CreateListDemoTest {

    @Test
    fun `check get method` () {
        val list = listOf(
            "1st Item", "2nd Item", "3rd Item", "4th Item", "5th Item"
        )
        assertEquals("2nd Item",list.get(1))
        assertEquals("3rd Item",list[2])
    }


    @Test
    fun `create list of 1 to 10`() {
        assertEquals(10,listOfOneToTen.size)
    }

    @Test
    fun `check first and last element of  list , first is 1 and last is 10`() {
        assertEquals(1,listOfOneToTen.get(0))
        assertEquals(10,listOfOneToTen.get(9))
    }

    @Test
    fun   `create empty list using emptyList` () {
        assertEquals(0,emptyListfun.size)
    }

    @Test
    fun   `create empty list using listof function` () {
        assertEquals(0,emptyListUsingListOf.size)
    }


    @Test
    fun   `list with empty Always give null` () {
        assertEquals(2, llistWithNull.size)
    }

    @Test
    fun   `null list always return list without  null` () {
        assertEquals(1, listOfNull.size)
    }

}