package com.vijayaneraye.quiz

import com.vijayaneraye.quiz.Gender.FEMALE
import com.vijayaneraye.quiz.Gender.MALE
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class CollectionTest {
    val heroes = listOf(
        Hero("The Captain", 60 , MALE),
        Hero("Frenchy",42,MALE),
        Hero("The Kid", 9,null),
        Hero("Lady Lauren", 29, FEMALE),
        Hero("First Mat", 29, MALE),
        Hero("Sir Stephen",37, MALE)
    )

    @Test
    fun `last hero name is sir sir stephen`() {
        assertThat(heroes.last().name,equalTo("Sir Stephen"))
    }

    @Test
    fun `if first hero's age is 30 then return name otherwise return null`() {
        assertNull(heroes.firstOrNull{ it.age == 30}?.name)
    }

    @Test
    fun `return NoSuchElementException if not check null`() {
        assertFailsWith<NoSuchElementException>{heroes.first{ it.age == 30}?.name}
    }

    @Test
    fun `find distinct age from heros`() {
        assertThat(heroes.map { it.age }.distinct().size, equalTo(5))
    }

    @Test
    fun `number of heroes with age less 30`() {
        assertThat(heroes.filter { it.age < 30 }.size, equalTo(3))
    }

    @Test
    fun `find older and youngest heroes using partition`() {
        val (youngest,oldest) = heroes.partition { it.age < 30 }
        assertThat(youngest.size , equalTo(3))
        assertThat(oldest.size, equalTo(3))
    }

    @Test
    fun `find name of hero whos age is oldest by age`() {
        assertThat(heroes.maxBy { it.age }?.name, equalTo("The Captain"))
    }

    @Test
    fun `check if all heroes are below 50 age`() {
        assertFalse {  heroes.all { it.age < 50 }}
    }

    @Test
    fun `check if any hero is female`() {
        assertTrue { heroes.any { it.gender == FEMALE } }
    }

    @Test
    fun `find  age of herors with same age`() {
        val mapAge : Map<Int, List<Hero>> = heroes.groupBy { it.age }
        val (age,group) = mapAge.maxBy{ (_, group) -> group.size }!!
        assertThat(age, equalTo(29))
        assertThat(group.size, equalTo(2))
    }

    @Test
    fun `associate list by name`() {
        val mapByName = heroes.associateBy { it.name }
        assertThat(mapByName["Frenchy"]?.age, equalTo(42))
        assertFailsWith<NoSuchElementException>{mapByName.getValue("Vijay").age}
    }

    @Test
    fun `pair heros with name`() {
        val (first,second) = heroes.
            flatMap { first -> heroes.map { second -> first to second } }
            .maxBy { it.first.age - it.second.age }!!
        assertThat(first.name, equalTo("The Captain"))
    }
}

data class Hero(val name: String, val age : Int, val gender : Gender?)

enum class Gender {
    MALE, FEMALE
}
