package leetcode.arrays101

class FindTheTwoJudge {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val trustPoint = IntArray(n + 1)
        for (relation in trust) {
            trustPoint[relation.first()]--
            trustPoint[relation.last()]++
        }

        for (i in 1..trustPoint.lastIndex) {
            if (trustPoint[i] == n - 1)
                return i
        }
        return -1
    }
}
