package ting.leetcode.arrays101

import kotlin.math.max

class ReplaceElementsWithGreatestElementOnRightSide {
    fun replaceElements(arr: IntArray): IntArray {
        if (arr.size == 1) {
            arr[0] = -1
            return arr
        }

        for (i in 0 until arr.lastIndex) {
            var isSecondElementBiggest = true;
            for (j in (i + 1)..arr.lastIndex) {
                if (arr[i + 1] < arr[j]) {
                    arr.fill(arr[j], i, j)
                    isSecondElementBiggest = false
                }
            }
            if (isSecondElementBiggest) {
                arr[i] = arr[i + 1]
            }
        }

        arr[arr.lastIndex] = -1
        return arr
    }

    fun replaceElementsWithPointer(arr: List<Int>): List<Int> {
//        if (arr.size == 1) {
//            arr[0] = -1
//            return arr
//        }
        val reversed = arr.asReversed().take(arr.size - 1)
        return reversed.scan(-1) { acc, i -> max(acc, i) } + reversed.last()

    }
}

