package ting.leetcode.arrays101

import kotlin.math.abs

class CheckIfNAndItsDoubleExist {
    fun checkIfExist(arr: IntArray): Boolean {
        if (arr.isEmpty()) return false
        for (i in 0..arr.lastIndex) {
            for (j in (i + 1)..arr.lastIndex) {
                if (arr[i] + arr[j] == 3 * arr[i] || arr[i] + arr[j] == 3 * arr[j]) {
                    return true
                }
            }
        }
        return false
    }

    fun checkIfExistWithBinarySearch(arr: IntArray): Boolean {
        if (arr.isEmpty()) return false
        arr.forEach {
            if(arr.binarySearch(it * 2) > 0 || arr.binarySearch(it / 2) > 0)
                return true
        }
        return false
    }
}