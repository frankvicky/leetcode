package ting.leetcode.beginnerguide

class ThirdMaximumNumber {
    fun thirdMax(nums: IntArray): Int {
        val uniqueDescendingNumsList = nums.distinct().sortedDescending()
        if (uniqueDescendingNumsList.size < 3)
            return uniqueDescendingNumsList.first()

        return uniqueDescendingNumsList[2]
    }

    fun thirdMaxWithSet(nums: IntArray): Int {
        val numsSet = nums.toSortedSet()
        return numsSet.elementAtOrElse(numsSet.size - 3) { numsSet.last() }
    }

    fun thirdMaxGetOrElse(nums: IntArray): Int {
        val uniqueDescendingNumsList = nums.distinct().sortedDescending()
        return uniqueDescendingNumsList.getOrElse(2) { uniqueDescendingNumsList.first() }
    }
}