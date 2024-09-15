package ting.leetcode.java.bfs;

import java.util.*;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        Collections.addAll(deads, deadends);

        int step = 0;
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (deads.contains(current)) {
                    continue;
                }

                if (current.equals(target)) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(current, j);
                    String down = minusOne(current, j);

                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }

                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String plusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else chars[j]++;
        return String.valueOf(chars);
    }

    private String minusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else chars[j]--;
        return String.valueOf(chars);
    }
}
