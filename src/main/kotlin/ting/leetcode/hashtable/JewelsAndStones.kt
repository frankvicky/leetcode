package ting.leetcode.hashtable

class JewelsAndStones {
    fun numJewelsInStones(jewels: String, stones: String): Int = jewels.sumOf { ch -> stones.count { it == ch } }

    fun numJewelsInStonesWithMap(jewels: String, stones: String): Int {
        val stonesMap = stones.withIndex().groupBy ({ it.value }, { it.index })
        var result = 0
        jewels.forEach { ch -> stonesMap[ch]?.let { result += it.size } }
        return result
    }
}