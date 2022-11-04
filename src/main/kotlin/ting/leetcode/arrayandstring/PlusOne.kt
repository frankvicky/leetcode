package ting.leetcode.arrayandstring

class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        val result = mutableListOf<Int>().apply {
            digits.reverse()
            digits[0]++
            addAll(digits.toList())
            add(0)
        }
        for (index in 0 until result.lastIndex) {
            if (result[index] >= 10) {
                result[index] = 0
                result[index + 1]++
            } else {
                result[index] %= 10
            }
        }
        return result.dropLastWhile { it == 0 }.reversed().toIntArray()
    }

    fun plusOneSimpleSolution(digits: IntArray): IntArray {
        for (i in digits.lastIndex downTo 0) {
            digits[i]++
            if(digits[i] < 10) return digits.dropWhile { it == 0 }.toIntArray()
            digits[i] = 0
        }

        val arr = IntArray(digits.size + 1)
        arr[0] = 1

        return arr
    }
}