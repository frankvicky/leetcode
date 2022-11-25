package ting.leetcode.hashtable

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LongestSubstringWithoutRepeatingCharactersTest {

    private lateinit var longestSubstringWithoutRepeatingCharacters: LongestSubstringWithoutRepeatingCharacters
    @BeforeEach
    fun setUp() {
        longestSubstringWithoutRepeatingCharacters = LongestSubstringWithoutRepeatingCharacters()
    }

    @Test
    fun lengthOfLongestSubstring() {
        assertEquals(3, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"))
        assertEquals(3, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"))
        assertEquals(1, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb"))
        assertEquals(2, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("aab"))
    }
}