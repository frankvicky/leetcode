package ting.leetcode.hashtable

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FirstUniqueCharacterInAStringTest {

    private lateinit var firstUniqueCharacterInAString: FirstUniqueCharacterInAString

    @BeforeEach
    fun setUp() {
        firstUniqueCharacterInAString = FirstUniqueCharacterInAString()
    }

    @Test
    fun firstUniqCharKotlin() {
        assertEquals(
            firstUniqueCharacterInAString.firstUniqChar("ting/leetcode"),
            0
        )

        assertEquals(
            firstUniqueCharacterInAString.firstUniqChar("loveleetcode"),
            2
        )

        assertEquals(
            firstUniqueCharacterInAString.firstUniqChar("aabb"),
            -1
        )
    }

}