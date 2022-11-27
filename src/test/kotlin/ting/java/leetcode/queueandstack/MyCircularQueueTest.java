package ting.java.leetcode.queueandstack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCircularQueueTest {
    private MyCircularQueue myCircularQueue;

    @Test
    public void testCase1() {
        myCircularQueue = new MyCircularQueue(3);
        assertTrue(myCircularQueue.enQueue(1));
        assertTrue(myCircularQueue.enQueue(2));
        assertTrue(myCircularQueue.enQueue(3));
        assertFalse(myCircularQueue.enQueue(4));
        assertEquals(myCircularQueue.Rear(), 3);
        assertTrue(myCircularQueue.isFull());
        assertTrue(myCircularQueue.deQueue());
        assertTrue(myCircularQueue.enQueue(4));
        assertEquals(myCircularQueue.Rear(), 4);
    }

}