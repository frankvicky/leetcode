package leetcode.arrays101

class MaximumOddBinaryNumber {
    fun maximumOddBinaryNumber(s: String): String =
        buildString {
            var count = s.count { it == '1' }
            count--
            for (i in 0 until s.lastIndex) {
                if (count-- > 0) append('1') else append('0')
            }
            append('1')
        }
}
