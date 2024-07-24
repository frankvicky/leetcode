package ting.leetcode.java.arrays101;

public class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitingTime = 0;
        double currentWaitingTIme = 0;

        for (int[] customer : customers) {
            currentWaitingTIme = Math.max(currentWaitingTIme, customer[0]) + customer[1];
            totalWaitingTime += currentWaitingTIme - customer[0];
        }

        return totalWaitingTime / customers.length;
    }
}
