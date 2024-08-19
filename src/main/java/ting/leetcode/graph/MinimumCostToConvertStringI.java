package ting.leetcode.graph;

import java.util.Arrays;

public class MinimumCostToConvertStringI {

    public static final long MAX = (long) Integer.MAX_VALUE + 1;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] costs = floydWarshall(original, changed, cost);

        int length = source.length();
        char[] sourceArray = source.toCharArray();
        char[] targetArray = target.toCharArray();

        long result = 0;
        for (int i = 0; i < length; i++) {
            long c = costs[sourceArray[i] - 'a'][targetArray[i] - 'a'];
            if (c == MAX) {
                return -1;
            }
            result += c;
        }
        return result;
    }

    public long[][] floydWarshall(char[] original, char[] changed, int[] cost) {
        int length = original.length;
        long[][] costs = new long[26][26];
        for (long[] c : costs) {
            Arrays.fill(c, MAX);
        }

        for (int i = 0; i < 26; i++) {
            costs[i][i] = 0;
        }

        for (int i = 0; i < length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            int c = cost[i];
            costs[from][to] = Math.min(costs[from][to], c);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (costs[i][k] < MAX && costs[k][j] < MAX) {
                        costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
                    }
                }
            }
        }
        return costs;
    }
}
