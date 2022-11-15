package ting.leetcode.hashtable

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class MyHashMapTest {
    private lateinit var myHashMap: MyHashMap

    @BeforeEach
    fun setUp(): Unit {
        myHashMap = MyHashMap()
        myHashMap.put(1, 1)
        myHashMap.put(1, 2)
        myHashMap.put(2, 3)
    }

    @Test
    fun put() {
        assertEquals(myHashMap.get(1), 2)
        assertEquals(myHashMap.get(2), 3)
    }

    @Test
    fun get() {
        assertEquals(myHashMap.get(1), 2)
        assertEquals(myHashMap.get(2), 3)
        assertEquals(myHashMap.get(100), -1)
    }

    @Test
    fun remove() {
        println(3)
        myHashMap.remove(1)
        myHashMap.remove(2)
        myHashMap.remove(999)
        assertEquals(myHashMap.get(1), -1)
        assertEquals(myHashMap.get(2), -1)
        assertEquals(myHashMap.get(999), -1)
    }
}