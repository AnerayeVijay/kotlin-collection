package com.vijayaneraye.list

import org.junit.Assert.assertEquals
import org.junit.Test

class ListIterationTest {

    @Test
    fun `filter list for even numbers` () {
        val listOfInt = listOf<Int>(1,2,3,4,5,6,7,8,9,10)
        val result  = getEvenNumber(listOfInt)
        assertEquals(5,result.size)
        assertEquals(2,result.first())

    }

    @Test
    fun `filter list for old numbers` () {
        val listOfInt = listOf<Int>(1,2,3,4,5,6,7,8,9,10)
        val result  = listOfInt.filter { it%2!=0 }
        assertEquals(5,result.size)
    }

    @Test
    fun `find sum for int from list` () {
        val listOfInt = listOf<Int>(1,2,3,4,5,6,7,8,9,10)
        val result  = listOfInt.sum()
        assertEquals(55,result)
    }

    @Test
    fun `find sum for all sum number from  list` () {
        val listOfInt = listOf<Int>(1,2,3,4,5,6,7,8,9,10)
        val result  = listOfInt.filter { it %2 == 0 }.sum()
        assertEquals(30,result)
    }


    @Test
    fun   `find distinct item from the list` () {
        val listOfInt = listOf<Int>(1,2,3,4,5,4,5,6,7,8,7,9,10)
        val result  = listOfInt.distinct()

        assertEquals(10,result.size)
    }


    val productList = listOf(Product("iPhone 8 Plus 64G", "Apple", 850.00),
        Product("Samsung Galaxy S8 64GB Unlocked Phone", "Samsung", 699.99),
        Product("iPad Pro 9.7-inch 32 GB", "Apple", 474.98),
        Product("Samsung Electronics Ultra HD Smart LED TV", "Samsung", 677.92),
        Product("Google Pixel Phone - 5 inch display", "Google", 279.95),
        Product("iPad Pro 9.7-inch 128G", "Apple", 574.99),
        Product("Google Wifi system 1-Pack", "Google", 149.90),
        Product("Samsung Galaxy Tab 4", "Samsung", 127.67))


    @Test
    fun `filter Apple product` () {
        val appleProducts = productList.filter { it.madeBy =="Apple" }
        assertEquals(3,appleProducts?.size)
    }




    val friends = listOf<Friend>(Friend("Andrii", "man", 1),
    Friend("Yasya", "women", 2),
    Friend("Alex", "man", 3))

    @Test
    fun `find friend name with id ==3` () {
        val friend = friends.filter { it.id ==3 }.map { it.name }.first()
        assertEquals("Alex",friend)

    }
}

data class Friend (val name: String, val geneder : String, val id : Int,val city: String ="Pune")
data class Product(val name: String, val madeBy: String, val price: Double)