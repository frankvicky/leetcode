class RunningSumOf1DArray {
    fun runningSum(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var currentSum = 0
//        for ((i, value) in nums.withIndex()) {
//            currentSum += value
//            result[i] = currentSum

        nums.forEachIndexed { index, value ->
            currentSum += value
            result[index] = currentSum
        }
        return result
    }
}