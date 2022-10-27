class FizzBuzz {
    fun fizzBuzz(n: Int): List<String> {
        return (1..n).map {
            when {
                it % 15 == 0 -> "FizzBuzz"
                it % 5 == 0 -> "Buzz"
                it % 3 == 0 -> "Fizz"
                else -> it.toString()
            }
        }
    }
}