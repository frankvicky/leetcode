package leetcode.arrays101

class SortArrayByParity {
    fun sortArrayByParity(nums: IntArray): IntArray {
        var writePointer = 0

        nums.forEachIndexed { index, value ->
            if (value and 1 == 0) {
                nums[writePointer] = value.also { nums[index] = nums[writePointer++] }
//                writePointer++
            }
        }

        return nums
    }
}
