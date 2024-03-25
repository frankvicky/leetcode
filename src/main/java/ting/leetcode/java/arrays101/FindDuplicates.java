package ting.leetcode.java.arrays101;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {

    // nums are in the range [1, n] = 意即該陣列最大數值為 lastIndex + 1
    // each integer appears once or twice
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (final int num : nums) {
            nums[Math.abs(num) - 1] *= -1; //透過將原陣列正負號反轉來確定該樹有沒有出現兩次
            if (nums[Math.abs(num) - 1] > 0)
                ans.add(Math.abs(num));
        }

        return ans;
    }
}
