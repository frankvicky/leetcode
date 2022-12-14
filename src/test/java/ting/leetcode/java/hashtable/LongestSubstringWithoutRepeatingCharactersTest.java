package ting.leetcode.java.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringWithoutRepeatingCharactersTest {
    private LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters;
    @BeforeEach
    void setUp() {
        longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
    }

    @Test
    void lengthOfLongestSubstring() {
        assertEquals(3, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(3, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
        assertEquals(1, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb"));
        assertEquals(2, longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("aab"));
    }
}