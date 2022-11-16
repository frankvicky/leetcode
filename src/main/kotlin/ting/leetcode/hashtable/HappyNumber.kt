package ting.leetcode.hashtable

class HappyNumber {
    fun isHappy(n: Int): Boolean {
        val notHappyNums = createNotHappyNums()
        var number = calculate(n)

        while (!notHappyNums.contains(number)) {
            number = calculate(number)
            if (number == 1) return true
        }

        return false
    }

    private fun createNotHappyNums(): Set<Int> {
        val notHappyNums = HashSet<Int>()
        val notHappyNumSeed = 2
        var notHappyNum = notHappyNumSeed
        do
            notHappyNum = calculate(notHappyNum)
        while (notHappyNums.add(notHappyNum))
        return notHappyNums
    }

    private fun calculate(n: Int): Int {
        val digits = mutableListOf<Int>()
        var result = n
        while (result != 0) {
            val digit = result % 10
            result /= 10
            digits.add(digit)
        }

        result = digits.fold(0) { acc, next ->  acc + (next * next) }
        return result
    }
}