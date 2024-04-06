package ting.leetcode.java.hashtable;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> cache = new TreeMap<>();
        ArrayList<Integer> neverLose = new ArrayList<>();
        ArrayList<Integer> lose1 = new ArrayList<>();

        for (int[] match : matches) {
            cache.putIfAbsent(match[0], 0);
            cache.merge(match[1], 1, Integer::sum);
        }

        for (Integer i : cache.keySet()) {
            if (cache.getOrDefault(i, -1) == 0)
                neverLose.add(i);
            else if (cache.getOrDefault(i, -1) == 1)
                lose1.add(i);
        }

        return List.of(neverLose, lose1);
    }


    public List<List<Integer>> findWinnersArr(int[][] matches) {
        int[] cache = new int[10_000_1];
        Arrays.fill(cache, -1);
        ArrayList<Integer> neverLose = new ArrayList<>();
        ArrayList<Integer> lose1 = new ArrayList<>();

        for (int[] match : matches) {
            if (cache[match[0]] == -1) {
                cache[match[0]] = 0;
            }

            if (cache[match[1]] == -1) {
                cache[match[1]] = 0;
            }
            cache[match[1]]++;
        }

        for (int i = 1; i < cache.length; i++) {
            if (cache[i] == 0) {
                neverLose.add(i);
            } else if (cache[i] == 1) {
                lose1.add(i);
            }
        }

        return List.of(neverLose, lose1);

    }
}

class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> findWinners(int[][] matches) {
        return new AbstractList<>() {
            @Override
            public int size() {
                init();
                return res.size();
            }

            @Override
            public List<Integer> get(int index) {
                init();
                return res.get(index);
            }

            private void init() {
                if (res != null) {
                    return;
                }
                res = new ArrayList<>(List.of(new ArrayList<>(), new ArrayList<>()));
                int max = Integer.MIN_VALUE;
                for (int[] match : matches) {
                    max = Math.max(max, Math.max(match[0], match[1]));
                }
                final boolean[] seen = new boolean[max + 1];
                for (int[] match : matches) {
                    seen[match[0]] = true;
                    seen[match[1]] = true;
                }
                final int[] loserArr = new int[max + 1];
                for (int[] match : matches) {
                    loserArr[match[1]]++;
                }
                for (int i = 1; i <= max; i++) {
                    if (seen[i]) {
                        switch (loserArr[i]) {
                            case 0 -> res.get(0).add(i);
                            case 1 -> res.get(1).add(i);
                        }
                    }
                }
            }
        };
    }
}
