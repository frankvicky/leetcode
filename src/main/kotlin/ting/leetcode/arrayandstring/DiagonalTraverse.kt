package ting.leetcode.arrayandstring

class DiagonalTraverse {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        val temp = mutableMapOf<Int, MutableList<Int>>()

        for (i in 0 .. (mat.size + mat.first().size - 2)) {
            temp[i] = mutableListOf()
        }

        for (i in mat.indices) {
            for ((j, value) in mat[i].withIndex()) {
                temp[i + j]?.add(value)
            }
        }
        temp.mapValues { (key, value) ->
            if (key and 1 == 0) value.reverse()
        }

        return temp.flatMap { it.value }.toIntArray()
    }

    fun findDiagonalOrderWithForEach(mat: Array<IntArray>): IntArray {
        val temp = mutableMapOf<Int, MutableList<Int>>()

        for (i in 0..(mat.size + mat.first().size - 2)) {
            temp[i] = mutableListOf()
        }

        mat.indices.forEach { i ->
            mat[i].forEachIndexed { j, value ->
                temp[i + j]?.add(value)
            }
        }

        temp.mapValues { (key, value) ->
            if (key and 1 == 0) value.reverse()
        }

        return temp.flatMap { it.value }.toIntArray()
    }
}