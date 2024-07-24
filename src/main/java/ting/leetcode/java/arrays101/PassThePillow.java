package ting.leetcode.java.arrays101;

public class PassThePillow {
    public int passThePillow(int n, int time) {
        int i = 1;
        boolean isInc = true;
        while (time > 0) {
            if (isInc) {
                if (++i == n) {
                    isInc = false;
                }
            } else {
                if (--i == 1) {
                    isInc = true;
                }
            }
            time--;
        }
        return i;
    }
}
