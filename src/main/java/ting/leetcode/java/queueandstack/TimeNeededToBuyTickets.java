package ting.leetcode.java.queueandstack;

public class TimeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;
        for (int a = 0; tickets[k] > 0; a++) {
            if (a == tickets.length) {
                a = 0;
            }

            if (tickets[a] == 0) {
                continue;
            }

            tickets[a]--;
            count++;
        }
        return count;
    }
}
