package ting.leetcode.arrayandstring

class ReverseWordsInAStringIII {
    fun reverseWords(s: String): String {
        return s.split(" ").map { it.reversed() }.filter { it.isNotEmpty() }.joinToString(" ")
    }
}