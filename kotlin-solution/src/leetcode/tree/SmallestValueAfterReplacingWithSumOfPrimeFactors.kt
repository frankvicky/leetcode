package leetcode.tree

class SmallestValueAfterReplacingWithSumOfPrimeFactors {
    fun smallestValue(n: Int): Int {
        var temp = getPrimeFactors(n)
        while (temp.size != 1) {
            temp = getPrimeFactors(temp.sum())
            if (temp.sum() == 4) return temp.sum()
        }
        return temp.first()
    }

    fun getPrimeFactors(num: Int): List<Int> {
        var number = num
        val result = mutableListOf<Int>()
        for (i in 2..number) {
            while (number % i == 0) {
                result.add(i)
                number /= i
            }
        }

        if (number > 2)
            result.add(number)

        return result
    }


}
