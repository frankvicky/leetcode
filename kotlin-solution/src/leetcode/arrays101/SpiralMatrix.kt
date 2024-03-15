package leetcode.arrays101

class SpiralMatrix {
    private val temp = mutableListOf<Int>()
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        // TODO: try to solve
        return temp
    }

    fun verticalMove(start: Int, end: Int, innerArray: IntArray): Unit {
        for (i in start..end) {
            temp.add(innerArray[i])
        }
    }

    fun horizontalMove(start: Int, end: Int, row:Int, matrix: Array<IntArray>): Unit {
        for (i in start..end) {
            temp.add(matrix[i][row])
        }
    }
}
