package ting.leetcode.java.arrays101;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int left = 0, right = people.length - 1;

        while (left <= right) {
            if (people[right] + people[left] <= limit) {
                left++;
            }
            right--;
            ans++;
        }

        return ans;
    }
}

