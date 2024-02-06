package ting.leetcode.java.enumeration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 窮舉演算法(Enumeration)

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        // 初始化一個ArrayList來存儲連續整數
        List<Integer> a = new ArrayList<>();

        // 循環從1到9
        for (int i = 1; i <= 9; ++i) {
            int num = i; // 初始化 num 為 i
            int nextDigit = i + 1; // 初始化 nextDigit 為 i + 1的數字

            // 如果 num 在 [low, high] 範圍內且 nextDigit 小於等於 9，
            // 則嘗試將 nextDigit 添加到 num 的末尾，
            // 如果添加後的 num 仍在 [low, high] 範圍內，
            // 則將添加後的 num 添加到列表 a 中
            while (num <= high && nextDigit <= 9) {
                num = num * 10 + nextDigit; // 形成數字
                if (low <= num && num <= high) {
                    a.add(num); // 如果數字在範圍內，則添加到列表中
                }
                ++nextDigit; // 為了下個循環，增加下一個數字
            }
        }

        Collections.sort(a); // 對列表進行排序
        return a; // 返回存放在 [low, high] 中所有連續數字的整數的列表
    }



    public static void main(String[] args) {
        List<Integer> temp = new SequentialDigits()
                .sequentialDigits(100, 300);
        temp.forEach(System.out::println);
    }
}
