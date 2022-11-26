package ting.leetcode.queueandstack

import kotlin.math.abs

class MyCircularQueue(k: Int) {

    // TODO: Refactor this ugly shit 
    private val data : MutableList<Int> = MutableList(k) { -1 }
    private var headIndex = -1
    private var tailIndex = -1

    fun enQueue(value: Int): Boolean {
        if (isFull()) {
            println("full")
            return false
        }
        if (headIndex == -1 && tailIndex == -1) {
            headIndex++
            tailIndex++
            data[tailIndex] = value
            return true
        }

        if (isEmpty()) {
            headIndex = 0
            tailIndex = 0
            data[tailIndex] = value
            return true
        }


        if (tailIndex + 1 > data.lastIndex)
            tailIndex = 0
        else
            tailIndex++

        data[tailIndex] = value

        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) return false
        if (headIndex != -1) {
            data[headIndex] = -1
        }

        if (headIndex + 1 > data.lastIndex)
            headIndex = 0
        else
            headIndex++


        return true
    }

    fun Front(): Int {
        if (headIndex == -1) return -1
        return data[headIndex]
    }

    fun Rear(): Int {
        if (tailIndex == -1) return -1
        return data[tailIndex]
    }

    fun isEmpty(): Boolean {
        val case1 = (headIndex != -1 && tailIndex != -1) && (data[tailIndex] == -1)
        val case2 = (abs(tailIndex - headIndex) == 1) && (data[headIndex] == -1)
        val case3 = headIndex == -1 && tailIndex == -1

        return case1 || case2 || case3
    }

    fun isFull(): Boolean {
        var tailIndex = tailIndex
        if (tailIndex + 1 > data.lastIndex) {
            tailIndex = 0
            return tailIndex == headIndex && data[tailIndex] != -1
        }
        return tailIndex + 1 == headIndex && data[tailIndex] != -1
    }

}