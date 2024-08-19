package ting.leetcode.java.arrays101;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class KthDistinctStringInAnArray {
    public String kthDistinct(String[] arr, int k) {
        Set<String> set = new LinkedHashSet<>();
        Set<String> seen = new HashSet<>();

        for (String s : arr) {
            if (seen.contains(s)) {
                set.remove(s);
            } else {
                set.add(s);
                seen.add(s);
            }
        }

        Iterator<String> iterator = set.iterator();
        String ans = "";
        for (int i = 0; i < k; i++) {
            if (iterator.hasNext()) {
                ans = iterator.next();
            } else {
                return "";
            }
        }

        return ans;
    }
}
