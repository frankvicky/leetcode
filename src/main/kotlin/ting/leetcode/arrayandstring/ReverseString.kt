package ting.leetcode.arrayandstring

class ReverseString {
    fun reverseString(s: CharArray): Unit {
        val secondPointer = s.lastIndex
        val middle = s.lastIndex / 2
        for (firstPointer in 0..middle) {
            s[firstPointer] = s[secondPointer - firstPointer].also { s[secondPointer - firstPointer] = s[firstPointer] }
        }
    }
}