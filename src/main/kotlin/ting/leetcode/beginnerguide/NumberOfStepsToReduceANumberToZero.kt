package ting.leetcode.beginnerguide

class NumberOfStepsToReduceANumberToZero {
    fun numberOfSteps(num: Int): Int {
        var result = num
        var counter = 0
        while (result != 0) {
            result = if (result and 1 == 0) result / 2 else result - 1
            counter++
        }

        return counter
    }
}