package leetcode.beginnerguide

class FizzBuzz {
    fun fizzBuzz(n: Int): List<String> {
        return (1..n).map {
            when {
                it % 15 == 0 -> "ting.leetcode.beginnerguide.FizzBuzz"
                it % 5 == 0 -> "Buzz"
                it % 3 == 0 -> "Fizz"
                else -> it.toString()
            }
        }
    }
}
