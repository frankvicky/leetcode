package ting.leetcode.hashtable

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MinimumIndexSumOfTwoListsTest {

    private lateinit var minimumIndexSumOfTwoLists: MinimumIndexSumOfTwoLists

    @BeforeEach
    fun setUp() {
        minimumIndexSumOfTwoLists = MinimumIndexSumOfTwoLists()
    }

    @Test
    fun findRestaurant() {
        assertTrue(
            minimumIndexSumOfTwoLists.findRestaurant(
                listOf("Shogun", "Tapioca Express", "Burger King", "KFC").toTypedArray(),
                listOf("Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun").toTypedArray()
            ) contentEquals listOf("Shogun").toTypedArray()
        )

        assertTrue(
            minimumIndexSumOfTwoLists.findRestaurant(
                listOf("Shogun", "Tapioca Express", "Burger King", "KFC").toTypedArray(),
                listOf("KFC", "Shogun", "Burger King").toTypedArray()
            ) contentEquals listOf("Shogun").toTypedArray()
        )

        assertTrue(
            minimumIndexSumOfTwoLists.findRestaurant(
                listOf("happy", "sad", "good").toTypedArray(),
                listOf("sad", "happy", "good").toTypedArray()
            ) contentEquals  listOf("happy", "sad").toTypedArray()
        )
    }
}