package leetcode.arrays101

import java.util.*

class FurthestBuildingYouCanReach {
    fun furthestBuilding(heights: IntArray, initialBricks: Int, initialLadders: Int): Int {
        var bricks = initialBricks
        var ladders = initialLadders
        val queue = PriorityQueue<Int>(compareByDescending { it })

        var i = 0
        while (i < heights.size - 1) {
            val (currentHeight, nextHeight) = heights[i] to heights[i + 1]
            if (currentHeight >= nextHeight) {
                i++
                continue
            }

            val difference = nextHeight - currentHeight
            bricks -= difference
            queue.offer(difference)

            if (bricks < 0) {
                queue.poll()?.let { bricks += it }
                ladders--
            }

            if (ladders < 0) break
            i++
        }

        return i
    }
}
