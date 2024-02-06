package ting.leetcode.recursion

class ReverseStringRecursion {
    fun reverseString(s: CharArray): Unit {
        reverse(0, s.lastIndex, s)
    }

    tailrec fun reverse(i: Int, j: Int, target: CharArray): Unit {
        if (i > j) return
        target[i] = target[j].also { target[j] = target[i] }
        reverse(i + 1, j - 1, target)
    }
}