package ting.leetcode.arrayandstring

class TwoSum2 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val result = IntArray(2)
        numbers.forEachIndexed { i, firstValue ->
            for (j in (i + 1)..numbers.lastIndex) {
                if (firstValue + numbers[j] == target) {
                    result[0] = i + 1
                    result[1] = j + 1
                    return result
                }
            }
        }
        return result
    }

    fun twoSumWithTwoPinter(numbers: IntArray, target: Int): IntArray {
        var firstPointer = 0
        var secondPointer = numbers.lastIndex
        while (numbers[firstPointer] + numbers[secondPointer] != target) {
            if (numbers[firstPointer] + numbers[secondPointer] > target) secondPointer-- else firstPointer++
        }
        return intArrayOf(++firstPointer, ++secondPointer)
    }
}