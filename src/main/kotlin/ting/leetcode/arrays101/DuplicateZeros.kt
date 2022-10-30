package ting.leetcode.arrays101

class DuplicateZeros {
    fun duplicateZeros(arr: IntArray): Unit {
        for (i in arr.lastIndex downTo 0) {
            if (arr[i] == 0 && i != arr.lastIndex) {
                val currentZeroIndex = i
                for (j in arr.lastIndex - 1 downTo currentZeroIndex) {
                    arr[j + 1] = arr[j]
                }
                arr[i + 1] = 0
            }
        }
    }
}