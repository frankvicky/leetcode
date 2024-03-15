package leetcode.arrays101

class FindPolygonWithTheLargestPerimeter {
    fun largestPerimeter(nums: IntArray): Long {
        nums.sort();

        val prefixSum = LongArray(nums.size)
        prefixSum[0] = nums.first().toLong()
        prefixSum[1] = nums.first().toLong() + nums[1].toLong()

        var ans = -1L

        for (i in 2..nums.lastIndex) {
            prefixSum[i] = nums[i] + prefixSum[i - 1]
            if (nums[i] < prefixSum[i - 1])
                ans = prefixSum[i]
        }

        return ans
    }
}
