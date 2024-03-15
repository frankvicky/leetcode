package leetcode.hashtable

class IsomorphicStrings {
    fun isIsomorphic(s: String, t: String): Boolean {
        val sList = s.withIndex().groupBy ({ it.value }, { it.index }).values.toList()
        val tList = t.withIndex().groupBy ({ it.value }, { it.index }).values.toList()
        return sList == tList
    }
}
