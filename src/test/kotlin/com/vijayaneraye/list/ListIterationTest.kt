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
    fun `multiple each item of list by two  and c  list` () {
        val listOfInt = listOf<Int>(1,2,3,4,5,6,7,8,9,10)
        val result  = listOfInt.map { it *2}.sum()
        assertEquals(100,result)
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
    fun `get product by made by using group by` () {
        val groupProductsWithMadeBy = productList.groupBy { it-> it.madeBy }
        val appleProducts =  groupProductsWithMadeBy.get("Apple")
        val googleProducts =  groupProductsWithMadeBy.get("Google")
        val samsungProducts =  groupProductsWithMadeBy.get("Samsung")

        assertEquals(3,appleProducts?.size)
        assertEquals(2,googleProducts?.size)
        assertEquals(3,samsungProducts?.size)
    }

    @Test

    fun `find sum of product price by compay` () {
       val sumofProduct = productList.groupBy { it.madeBy }
           .mapValues { (company,product) -> product.sumByDouble { it.price } }
        val expectedApplePriceSum = 1899.97
        val expectedSamsungPriceSum = 1505.58
        val expectedGooglePriceSum = 429.85
        assertEquals(expectedApplePriceSum,sumofProduct.get("Apple"))
        assertEquals(expectedSamsungPriceSum,sumofProduct.get("Samsung"))
        assertEquals(expectedGooglePriceSum,sumofProduct.get("Google"))
    }
}


data class Product(val name: String, val madeBy: String, val price: Double)