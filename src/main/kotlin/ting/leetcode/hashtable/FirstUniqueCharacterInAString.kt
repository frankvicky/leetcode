package ting.leetcode.hashtable

class FirstUniqueCharacterInAString {
    fun firstUniqChar(s: String): Int {
        val map = s.withIndex().groupBy({ it.value }, { it.index }).filter { it.value.size == 1 }
        return if (map.isNotEmpty()) map.values.first().first() else -1
    }
}