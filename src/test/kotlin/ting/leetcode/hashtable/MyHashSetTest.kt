package ting.leetcode.hashtable

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MyHashSetTest {
    private val myHashSet by lazy { MyHashSet() }

    @Test
    fun contains() {
        myHashSet.add(1)
        myHashSet.add(2)
        assertTrue(myHashSet.contains(1))
        assertTrue(myHashSet.contains(2))
        assertFalse(myHashSet.contains(3))
    }
}