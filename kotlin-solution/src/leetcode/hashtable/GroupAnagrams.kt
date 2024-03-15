package leetcode.hashtable

class GroupAnagrams {
    fun groupAnagrams(strArray: Array<String>): List<List<String>> = strArray.groupBy { it.toCharArray().sorted() }.values.toList()
}
