package ting.leetcode.java.arrays101;

import java.util.Arrays;

public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        if (tokens.length == 0) {
            return 0;
        }

        Arrays.sort(tokens);
        int score = 0;
        int left = 0;
        int right = tokens.length - 1;

        while (left < right) {
            if (tokens[left] <= power) {
                power -= tokens[left];
                score++;
                left++;
            } else if (tokens[right] > power && score > 0) {
                score--;
                power += tokens[right];
                right--;
            } else {
                break;
            }
        }

        if (power >= tokens[right]) {
            score++;
        }

        return score;
    }
}
