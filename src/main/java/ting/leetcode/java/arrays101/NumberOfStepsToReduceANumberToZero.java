package ting.leetcode.java.arrays101;

public class NumberOfStepsToReduceANumberToZero {

    public int numberOfSteps(int num) {
        var count = 0;
        var number = num;
        while(number > 0) {
            number = (number & 1)== 1 ? number - 1 : number / 2;
            count++;
        }
        return count;
    }
}
