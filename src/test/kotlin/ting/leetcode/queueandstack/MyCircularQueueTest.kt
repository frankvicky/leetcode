package ting.leetcode.queueandstack

import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MyCircularQueueTest {
    private lateinit var myCircularQueue: MyCircularQueue

    @Test
    fun testCase1(): Unit {
        myCircularQueue = MyCircularQueue(3)
        assertTrue(myCircularQueue.enQueue(1))
        assertTrue(myCircularQueue.enQueue(2))
        assertTrue(myCircularQueue.enQueue(3))
        assertFalse(myCircularQueue.enQueue(4))
        assertEquals(myCircularQueue.Rear(), 3)
        assertTrue(myCircularQueue.isFull())
        assertTrue(myCircularQueue.deQueue())
        assertTrue(myCircularQueue.enQueue(4))
        assertEquals(myCircularQueue.Rear(), 4)
    }

    @Test
    fun testCase2(): Unit {
        myCircularQueue = MyCircularQueue(6)
        assertTrue(myCircularQueue.enQueue(6))
        assertEquals(myCircularQueue.Rear(), 6)
        assertEquals(myCircularQueue.Rear(), 6)
        assertTrue(myCircularQueue.deQueue())
        assertTrue(myCircularQueue.enQueue(5))
        assertEquals(myCircularQueue.Rear(), 5)
        assertTrue(myCircularQueue.deQueue())
        assertEquals(myCircularQueue.Front(), -1)
        assertFalse(myCircularQueue.deQueue())
        assertFalse(myCircularQueue.deQueue())
        assertFalse(myCircularQueue.deQueue())
    }
}