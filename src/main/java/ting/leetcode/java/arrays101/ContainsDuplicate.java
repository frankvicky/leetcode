package ting.leetcode.java.arrays101;

import com.sun.source.tree.NewArrayTree;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            if (!numbers.add(num))
                return true;
        }
        return false;
    }
}
