package ting.leetcode.arrays101

class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        val shortestStr = strs.minBy { it.length }
        var result = ""
        for (i in shortestStr.length downTo 1) {
            result = shortestStr.take(i)
            val groupResult = strs.groupBy { it.take(i) } [result]
            if (groupResult != null && groupResult.size == strs.size) return result else result = ""
        }
        return result
    }

    fun longestCommonPrefixWithAll(strs: Array<String>): String {
        return StringBuilder().apply {
            strs.minBy { it.length } .forEachIndexed { index, char ->
                if (strs.all { it[index] == char })
                    append(char)
                else
                    return toString()
            }
        }.toString()
    }

    fun longestCommonPrefixWithGroupByAndAll(strs: Array<String>): String {
        val shortestStr = strs.minBy { it.length }
        var result = ""
        for (i in shortestStr.length downTo 1) {
            result = shortestStr.take(i)
            if (strs.all { it.take(i) == result }) return result else result = ""
        }
        return result
    }
}
