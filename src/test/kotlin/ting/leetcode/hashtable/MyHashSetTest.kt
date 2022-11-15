package ting.leetcode.hashtable

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class MyHashSetTest {
    private lateinit var myHashSet: MyHashSet

    @BeforeEach
    fun setUp(): Unit {
        myHashSet = MyHashSet()
        myHashSet.add(1)
        myHashSet.add(2)
    }
    @Test
    fun add(): Unit {
        myHashSet.add(3)
        myHashSet.add(4)
        assertTrue(myHashSet.contains(3))
        assertTrue(myHashSet.contains(4))
    }
    @Test
    fun remove(): Unit {
        myHashSet.remove(3)
        myHashSet.remove(4)
        assertFalse(myHashSet.contains(3))
        assertFalse(myHashSet.contains(4))

    }
    @Test
    fun contains() {
        assertTrue(myHashSet.contains(1))
        assertTrue(myHashSet.contains(2))
        assertFalse(myHashSet.contains(3))
    }
}