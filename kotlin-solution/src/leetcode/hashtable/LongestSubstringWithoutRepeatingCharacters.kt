package leetcode.hashtable

class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        var currentStart = 0
        var currentMax = 0
        val map = hashMapOf<Char, Int>()
        s.forEachIndexed { i, currentChar ->
            map[currentChar]?.takeIf { it >= currentStart }?.let {
                currentMax = kotlin.math.max(i - currentStart, currentMax)
                currentStart = it + 1
            }
            map[currentChar] = i
        }
        return kotlin.math.max(currentMax, s.length - currentStart)

    }
}
