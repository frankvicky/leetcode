package ting.leetcode.java.arrays101;

import java.util.Arrays;
import java.util.function.Function;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts).map(account -> Arrays.stream(account).sum()).max(Integer::compareTo).get();
    }
}
