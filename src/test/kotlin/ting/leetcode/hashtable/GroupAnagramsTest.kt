package ting.leetcode.hashtable

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class GroupAnagramsTest {

    private lateinit var groupAnagrams: GroupAnagrams

    @BeforeEach
    fun setUp() {
        groupAnagrams = GroupAnagrams()
    }

    @Test
    fun groupAnagrams() {
        val result = groupAnagrams.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
        val shouldBe = listOf(listOf("bat"), listOf("nat", "tan"), listOf("ate","eat","tea"))
        result.forEach { element ->
            assertTrue(shouldBe.any { equalsIgnoreOrder(it, element) })
        }
    }

    private fun <T> equalsIgnoreOrder(list1: List<T>, list2: List<T>) =
        list1.size == list2.size && list1.toSet() == list2.toSet()
}