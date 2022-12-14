package ting.leetcode.queueandstack

import kotlin.math.abs

class MyCircularQueue(k: Int) {

    private val data: MutableList<Int> = MutableList(k) { -1 }
    private var headIndex = -1
    private var tailIndex = -1

    fun enQueue(value: Int): Boolean {
        if (isFull()) return false
        if (isEmpty()) {
            headIndex = 0
            tailIndex = 0
            data[tailIndex] = value
            return true
        }

        tailIndex = indexPlusOne(tailIndex)
        data[tailIndex] = value
        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) return false
        if (headIndex != -1) data[headIndex] = -1
        headIndex = indexPlusOne(headIndex)
        return true
    }

    fun Front(): Int = if (headIndex == -1) -1 else data[headIndex]

    fun Rear(): Int = if (tailIndex == -1) -1 else data[tailIndex]

    fun isEmpty(): Boolean =
        run {
            val case1 = (abs(tailIndex - headIndex) == 1) && (data[headIndex] == -1)
            val case2 = headIndex == -1 && tailIndex == -1
            case1 || case2
        }


    fun isFull(): Boolean =
        with(tailIndex) {
            val tailIndex = (this + 1) % data.size
            tailIndex == headIndex && data[tailIndex] != -1
        }

    private fun indexPlusOne(index: Int): Int =
        index.run { if (this == data.lastIndex) 0 else this + 1 }
}