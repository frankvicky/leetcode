package leetcode.arrays101

class ArrayPartition1 {
    fun arrayPairSum(nums: IntArray): Int {
        return nums.sorted().chunked(2) { it.min() }.sum()
    }

    fun arrayPairSumOldVer(nums: IntArray): Int {
        return nums.sorted().chunked(2) { it.min() }.fold(0) { acc, next -> acc + next }
    }

    fun arrayPairSumWith(nums: IntArray): Int {
        return nums.run {
            var result = 0
            sort()
            forEachIndexed { index, value ->
                if (index and 1 == 0) result += value
            }
            result
        }
    }
}
