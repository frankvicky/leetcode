package leetcode.arrays101

class NumMatrix(matrix: Array<IntArray>) {

    private var preSum: Array<IntArray>

    init {
        val m = matrix.size
        val n = if (m == 0) 0 else matrix[0].size
        // Construct preFix sum matrix
        preSum = Array(m + 1) { IntArray(n + 1) }
        for (i in 1..m) {
            for (j in 1..n) {
                // Calculate the element sum of each matrix [0, 0, i, j]
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] +
                        matrix[i - 1][j - 1] - preSum[i - 1][j - 1]
            }
        }
    }

    fun sumRegion(x1: Int, y1: Int, x2: Int, y2: Int): Int {
        return preSum[x2 + 1][y2 + 1] - preSum[x1][y2 + 1] -
                preSum[x2 + 1][y1] + preSum[x1][y1]
    }
}
