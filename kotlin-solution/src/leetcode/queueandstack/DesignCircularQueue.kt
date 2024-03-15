package leetcode.queueandstack

import kotlin.math.abs

class MyCircularQueue(k: Int) {
    private val queue: IntArray = IntArray(k) { -1 }
    private var head = -1
    private var tail = -1

    fun enQueue(value: Int): Boolean {
        if (isFull()) {
            return false
        }

        if (isEmpty()) {
            tail = 0
            head = 0
        }

        queue[tail++] = value
        if (tail >= queue.size) {
            tail %= queue.size
        }

        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) {
            head = -1
            tail = -1
            return false
        }

        queue[head++] = -1

        if (head >= queue.size) {
            head %= queue.size
        }

        return true
    }

    fun Front(): Int {
        if (isEmpty()) {
            return -1;
        }

        return queue[head]
    }

    fun Rear(): Int {
        if (isEmpty()) {
            return -1
        }

        return if (tail - 1 < 0) queue[queue.lastIndex] else queue[tail - 1]
    }

    fun isEmpty(): Boolean {
        if (head == -1 && head == tail) {
            return true
        }

        return head == tail && queue[head] == -1
    }

    fun isFull(): Boolean {
        if (isEmpty()) {
            return false
        }

        return head == tail && queue[head] != -1
    }
}
