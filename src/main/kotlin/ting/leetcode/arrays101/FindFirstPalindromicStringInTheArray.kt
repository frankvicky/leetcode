package ting.leetcode.arrays101

class FindFirstPalindromicStringInTheArray {
    fun firstPalindrome(words: Array<String>): String =
        words.find { it.isPalindrome() } ?: ""

    private fun String.isPalindrome(): Boolean {
        var left = 0
        var right = lastIndex
        while (left < right) {
            if (this[left++] != this[right--])
                return false
        }
        return true
    }
}
