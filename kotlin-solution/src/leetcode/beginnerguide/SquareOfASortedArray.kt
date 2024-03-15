package leetcode.beginnerguide

class SquareOfASortedArray {
    fun sortedSquares(nums: IntArray): IntArray {
        return nums.map { it * it }.sorted().toIntArray()
    }

    fun sortedSquaresInplace(nums: IntArray): IntArray {
        nums.forEachIndexed { index, value ->
            nums[index] = value * value
        }
        nums.sort()
        return nums
    }
}
