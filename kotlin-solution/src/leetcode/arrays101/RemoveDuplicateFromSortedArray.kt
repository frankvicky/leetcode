package leetcode.arrays101

class RemoveDuplicateFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        val distinctArray = nums.distinct()
        for (i in 0..distinctArray.lastIndex) {
            nums[i] = distinctArray[i]
        }
        return distinctArray.size
    }

    fun removeDuplicatesWithFor(nums: IntArray): Int {
        var currentIndex = 0

        for (i in 1..nums.lastIndex) {
            if (nums[currentIndex] < nums[i]) {
                currentIndex++
                nums[currentIndex] = nums[i]

            }
        }
        return currentIndex + 1
    }
}
