package ting.leetcode.hashtable

class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val validator = { chArray: CharArray ->
            val charMap = chArray.withIndex().groupBy({ it.value }, { it.index })
            !charMap.any { (k, v) -> k != '.' && v.size > 1  }
        }

        val rows = board.withIndex().groupBy({ it.index }, { it.value }).values.flatten()
        rows.forEach { if (!validator(it)) return false }

        val columns = (0..8).map { index -> rows.map { row -> row[index] }.toCharArray() }
        columns.forEach { if (!validator(it)) return false }

        val tempMap = mutableMapOf<Int, MutableList<Char>>()
        board.forEach { array -> array.withIndex().groupByTo(tempMap, { it.index / 3 }, { it.value }) }
        val boxes = tempMap.values.map{ list -> list.chunked(9).map { it.toCharArray() } }.flatten()

        boxes.forEach { if (!validator(it)) return false }

        return true
    }
}
