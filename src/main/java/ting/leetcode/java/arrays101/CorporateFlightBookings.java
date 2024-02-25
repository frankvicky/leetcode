package ting.leetcode.java.arrays101;

public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] bookedSeat = new int[n];
        for (int[] booking : bookings) {
            increase(booking[0], booking[1], booking[2], bookedSeat);
        }

        for (int i = 1; i < bookedSeat.length; i++) {
            bookedSeat[i] = bookedSeat[i - 1] + bookedSeat[i];
        }
        return bookedSeat;
    }

    public void increase(int from, int to, int count, int[] arr) {
        arr[from - 1] += count;
        if (to - 1 < arr.length - 1) {
            arr[to] -= count;
        }
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25}
        };
        new CorporateFlightBookings().corpFlightBookings(array, 5);
    }
}
