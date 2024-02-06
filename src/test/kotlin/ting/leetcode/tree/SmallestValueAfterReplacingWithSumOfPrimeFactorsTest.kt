package ting.leetcode.tree

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SmallestValueAfterReplacingWithSumOfPrimeFactorsTest {

    private lateinit var solution: SmallestValueAfterReplacingWithSumOfPrimeFactors

    @BeforeEach
    fun setUp() {
        solution = SmallestValueAfterReplacingWithSumOfPrimeFactors()
    }

    @Test
    fun smallestValue() {
        println(solution.smallestValue(15))
    }

}