package leetcode.hashtable

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        val result = IntArray(2)
        nums.forEachIndexed { index, value ->
            map[value]?.let {
                result[0] = nums.indexOf(it)
                result[1] = index
            }
            map[target - value] = value
        }
        return result
    }
}
