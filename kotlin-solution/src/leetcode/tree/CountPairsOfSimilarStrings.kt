package leetcode.tree

class CountPairsOfSimilarStrings {
    fun similarPairs(words: Array<String>): Int {
        var count = 0
        words.forEachIndexed { i, firstPointer ->
            for (j in (i + 1) .. words.lastIndex) {
                if (firstPointer.toHashSet() == words[j].toSet()) count++
            }
        }
        return count
    }
}
