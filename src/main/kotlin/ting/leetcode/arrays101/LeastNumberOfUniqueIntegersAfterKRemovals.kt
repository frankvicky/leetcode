package ting.leetcode.arrays101

import java.util.*

class LeastNumberOfUniqueIntegersAfterKRemovals {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        arr.sort()
        val queue = PriorityQueue<Int>()
        var count = 0
        var current = arr.first()

        for (num in arr) {
            if (current != num) {
                queue.add(count)
                current = num
                count = 1
            } else count++
        }

        queue.add(count)

        var accumulator = 0
        while (accumulator < k)
            accumulator += queue.poll()

        return if (accumulator == k) queue.size else queue.size + 1
    }
}
