package ting.leetcode.hashtable

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class IsomorphicStringsTest {
    private lateinit var isomorphicStrings: IsomorphicStrings
    @BeforeEach
    fun setUp() {
        isomorphicStrings = IsomorphicStrings()
    }

    @Test
    fun isIsomorphic() {
        assertTrue(isomorphicStrings.isIsomorphic("egg", "add"))
        assertFalse(isomorphicStrings.isIsomorphic("foo", "bar"))
        assertTrue(isomorphicStrings.isIsomorphic("paper", "title"))
    }
}