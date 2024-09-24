package ting.leetcode.java.math;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        // 可以理解為三個指向有序鍊表頭節點的指針
        int p2 = 1, p3 = 1, p5 = 1;
        // 可以理解為三個有序鍊表的頭節點值
        int product2 = 1, product3 = 1, product5 = 1;
        // 可以理解為最終合併的有序鍊表
        int[] ugly = new int[n + 1];

        // 可以理解為鍊表上的指針
        int p = 1;

        while (p <= n) {
            int min = Math.min(Math.min(product2, product3), product5);
            ugly[p++] = min;

            if (min == product2) {
                product2 = 2 * ugly[p2++];
            }

            if (min == product3) {
                product3 = 3 * ugly[p3++];
            }

            if (min == product5) {
                product5 = 5 * ugly[p5++];
            }
        }
        return ugly[n];
    }
}
