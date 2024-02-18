package ting.leetcode.arrays101

class StrStr {
    fun strStr(haystack: String, needle: String): Int {
        if (!haystack.contains(needle)) return -1
        return haystack.indexOf(needle)
    }

    fun strStrScratch(haystack: String, needle: String): Int {
        if (needle.length > haystack.length) return -1
        var firstOccurrence = -1
        haystack.forEachIndexed { i, hChar ->
            if (needle[0] == hChar) {
                var checkIndex = 0
                for (j in 1..needle.lastIndex) {
                    if ((i + j > haystack.lastIndex) || haystack[i + j] != needle[j]) break
                    checkIndex++
                }
                if (checkIndex + 1 == needle.length) {
                    firstOccurrence = i
                    return firstOccurrence
                }
            }
        }
        return firstOccurrence
    }
}
