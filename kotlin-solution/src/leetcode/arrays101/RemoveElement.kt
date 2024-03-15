package leetcode.arrays101

class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        val result = nums.size - nums.count { it == `val` }
        for (i in 0..nums.lastIndex) {
            if (nums[i] == `val` && i != nums.lastIndex) {
                var currentIndex = i
                for (j in i .. nums.lastIndex) {
                    if (nums[j] == `val`) {
                        continue
                    }
                    nums[currentIndex] = nums[j]
                    currentIndex++
                }

            }
        }
        return result
    }

    fun removeElementWithForEach(nums: IntArray, value: Int): Int {
        var counter = 0
        nums.forEach { if (it != value) nums[counter++] = it }
        return counter
    }


}
