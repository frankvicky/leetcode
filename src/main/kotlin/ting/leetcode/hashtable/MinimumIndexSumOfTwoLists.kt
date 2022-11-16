package ting.leetcode.hashtable

class MinimumIndexSumOfTwoLists {
    fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
        val repeatStrings = list1.toSet() intersect list2.toSet()
        val totalList = list1 + list2
        val map = totalList.withIndex().groupBy({ it.value }, { it.index })
        val repeatStringsIndexSumMap = repeatStrings.map { it to (map[it]!!.sum()) }.sortedBy { it.second }
        return repeatStringsIndexSumMap.filter { it.second == repeatStringsIndexSumMap.first().second }.map { it.first }.toTypedArray()
    }
}