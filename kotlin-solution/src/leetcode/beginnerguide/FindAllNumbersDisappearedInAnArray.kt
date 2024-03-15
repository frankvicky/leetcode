package leetcode.beginnerguide

class FindAllNumbersDisappearedInAnArray {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val result = mutableListOf<Int>()
        for (i in nums.indices) {
            if(nums.indexOf(i + 1) == -1) result.add(i + 1)
        }
        return result.toList()
    }

    fun findDisappearedNumbersWithSubtract(nums: IntArray): List<Int> {
        val result = List(nums.size) { it + 1 }
        result subtract nums.toSet()
        return result
    }
}
