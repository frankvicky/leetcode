package ting.leetcode.java.queueandstack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperaturesBrutal(int[] temperatures) {
        int[] answers = new int[temperatures.length];
        int pointer = 0;

        while (pointer < temperatures.length - 1) {
            int count = 0;
            for (int i = pointer; i < temperatures.length; i++) {
                if (temperatures[pointer] < temperatures[i]) {
                    answers[pointer] = count;
                    break;
                } else {
                    count++;
                }
            }
            pointer++;
        }
        return answers;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answers = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            /*
             * 此內部迴圈在以下兩種情況下會被執行：
             * 1)堆疊不為空
             * 2)堆疊頂部的元素（表示前一天的溫度索引位置）所對應的溫度小於當前遍歷的溫度。
             * 這個迴圈在我們找到一個溫度比前一天高的時候被打破。
             */
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                /*
                 * pop出堆疊頂部的元素，這個元素是最近一次的溫度索引位置。
                 * 在這一步中，我們已經找到了一個比這個溫度高的天氣，此時只需直接計算這兩個天數的相差就可以得出這個天數需要等多久可以看到比其更高的溫度。
                 */
                int storedIndex = stack.pop();
                answers[storedIndex] = i - storedIndex;
            }
            /*
             * 如果當前溫度沒有比其高的溫度，我們就把它push入堆疊中，等待之後的溫度來和它做比較。
             */
            stack.push(i);
        }

        return answers;
    }


    public static void main(String[] args) {
        int[] a = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] b = new DailyTemperatures().dailyTemperatures(a);
        for (int i : b) {
            System.out.println(i);
        }
    }
}

// order
// last must be 0

