package ting.leetcode.java.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {
    private final Set<String> set = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        boolean[] used = new boolean[tiles.length()];
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        backtrack(chars, "", used);
        return set.size();
    }

    private void backtrack(char[] tiles, String str, boolean[] used) {
        for (int i = 0; i < tiles.length; i++) {
            if (used[i] || tiles[i] == tiles [i - 1] && !used[i - 1]) {
                continue;
            }

            String newStr = str + tiles[i];
            used[i] = true;
            set.add(newStr);
            backtrack(tiles, newStr, used);
            used[i] = false;
        }
    }
}
