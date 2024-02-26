package ting.leetcode.arrays101

class RotateImage {
    fun rotate(matrix: Array<IntArray>): Unit {
        for (i in matrix.indices) {
            for (j in i until matrix.size) {
                matrix[i][j] = matrix[j][i]
                    .also { matrix[j][i] = matrix[i][j] }
            }
        }

        for (row in matrix) {
            row.reverse()
        }
    }
}
