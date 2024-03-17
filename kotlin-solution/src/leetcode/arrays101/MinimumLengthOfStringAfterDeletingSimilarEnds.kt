package leetcode.arrays101

class MinimumLengthOfStringAfterDeletingSimilarEnds {
    fun minimumLength(s: String): Int {
        var left = 0
        var right = s.lastIndex

        while (left < right) {
            if (s[left] != s[right]) break
            val streakChar = s[left]

            while (s[left] == streakChar && left < right) {
                ++left
            }

            while (s[right] == streakChar && left <= right) {
                --right
            }
        }

        return right - left + 1
    }
}
