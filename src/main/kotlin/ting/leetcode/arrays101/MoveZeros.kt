package ting.leetcode.arrays101

class MoveZeros {
    //雙指針法，透過設立另一個 writer 指針專沒用來寫入，寫入完成後推進，而 reader 指針會尋找符合條件的元素。
    fun moveZeroes(nums: IntArray): Unit {
        if (nums.isEmpty()) return
        val numbersOfZero = nums.count { it == 0 }
        if (numbersOfZero == 0) return


        var writerPoint = 0
        for (i in 0..nums.lastIndex) {
            if (nums[i] != 0) {
                nums[writerPoint] = nums[i]
                writerPoint++
            }
        }
        nums.fill(0, nums.size - numbersOfZero)
    }

    fun moveZeroesWithForEach(nums: IntArray): Unit {
        if (nums.isEmpty()) return
        val numbersOfZero = nums.count { it == 0 }
        if (numbersOfZero == 0) return


        var writerPoint = 0
        nums.forEachIndexed { index, value ->
            if (value != 0) {
                nums[writerPoint++] = nums[index]
            }
        }
        nums.fill(0, nums.size - numbersOfZero)
    }

    fun moveZeroesWithFilter(nums: IntArray): Unit {
        nums.run {
            val numsList = filter { it != 0 }
            numsList.forEachIndexed { index, value ->
                nums[index] = value
                if (index == lastIndex - numsList.lastIndex || index == 0)
                    nums.fill(0, index + 1, nums.size)
            }
        }
    }

}