package com.vijayaneraye.list

val listOfOneToTen  = listOf<Int>(1,2,3,4,5,6,7,8,9,10)

val emptyListfun = emptyList<Any>()

val emptyListUsingListOf = listOf<Any>()

val llistWithNull = listOf("a", null)

val listOfNull = listOfNotNull<String>("a", null)   // [a]
// [a, null]
