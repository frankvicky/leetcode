package leetcode.arrays101

class BagOfTokens {
    fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
        if (tokens.isEmpty()) {
            return 0;
        }

        tokens.sort()
        var score = 0
        var left = 0
        var right = tokens.lastIndex
        var power = power

        while (left < right) {
            if (power >= tokens[left]) {
                power -= tokens[left++]
                score++
            }
            else if (power < tokens[right] && score > 0) {
                power += tokens[right--]
                score--
            }
            else break
        }

        return if (power >= tokens[right]) score + 1 else score
    }
}
