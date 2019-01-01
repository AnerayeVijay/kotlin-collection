package com.vijayaneraye.list

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
class ListMapAndFilterMap {
    // --  map()
    //  This function just maps one collection to another. For example, you need to get a list of names from the friends list:

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

        assertEquals(3, appleProducts?.size)
        assertEquals(2, googleProducts?.size)
        assertEquals(3, samsungProducts?.size)
    }

    @Test

    fun `find sum of product price by compay` () {
        val sumofProduct = productList.groupBy { it.madeBy }
            .mapValues { (company,product) -> product.sumByDouble { it.price } }
        val expectedApplePriceSum = 1899.97
        val expectedSamsungPriceSum = 1505.58
        val expectedGooglePriceSum = 429.85
        assertEquals(expectedApplePriceSum, sumofProduct.get("Apple"))
        assertEquals(expectedSamsungPriceSum, sumofProduct.get("Samsung"))
        assertEquals(expectedGooglePriceSum, sumofProduct.get("Google"))
    }

    @Test
    fun `find list of product Company`() {
        val result = productList.map { it.madeBy }.distinct()
        assertEquals(3, result.size)
    }


    val friends = listOf<Friend>(Friend("Andrey", "man", 32, "Pune"),
        Friend("Valik", "man", 32, "Dnipro"),
        Friend("Lexa", "man", 31, "Philadelphia"),
        Friend("Tolik", "man", 32, "Dnipro"),
        Friend("Dimon", "man", 32, "Kharkiv"),
        Friend("Nikitos", "man", 32, "Kyiv"),
        Friend("Igor", "man", 32, "Pune"),
        Friend("Anna", "women", 32, "Pune"),
        Friend("Serega", "man", 32, "Stockholm"),
        Friend("Michael", "man", 32, "New York"),
        Friend("Slavik", "man", 32, "Novomoskosvsk"))


    @Test
    fun `multiple each item of list by two  and c  list`() {
        val listOfInt = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val result = listOfInt.map { it * 2 }.sum()
        assertEquals(110, result)
    }



    @Test
    fun `group friends by city`() {
        val result = friends.groupBy { it.city }
        val friendsfrompune = result.get("Pune")
        assertEquals(3, friendsfrompune?.size)
        val name = friendsfrompune?.filter {   it.name=="Igor" }?.map { it.name }?.first()
        assertEquals("Igor", name)
    }

    @Test
    fun `get name of all friends`() {
        val friendsName = friends.map { it.name }
        assertTrue(friendsName.contains("Dimon"))
        assertTrue(friendsName.contains("Slavik"))
    }

    @Test
    fun `get all women friends from list` () {
        val friendsName = friends.filter { it.geneder == "women" }.map { it.name }
        assertEquals(1, friendsName.size)
        assertTrue(friendsName.contains("Anna"))
    }

    val developers = listOf(Developer("A", setOf("Java","Kotlin")),
        Developer("B", setOf("Java","Python")),
            Developer("C", setOf("groovy")),
        Developer("D", setOf("C#","C++")),
                Developer("E", setOf("scala","DontNet")))
    @Test
    fun `get all skills from developers`() {
        val skills = developers.flatMap { it.skills }
        assertTrue(skills.containsAll(setOf("Java","Kotlin")));
        assertTrue(skills.containsAll(setOf("scala","groovy")));
    }
}

data class Developer(val name: String,val skills : Set<String>)