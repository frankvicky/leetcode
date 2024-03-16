package ting.leetcode.java.queueandstack;

import java.util.LinkedList;

public class ParenthesesScore {
    public int parenthesesScore(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int score = 0;
                while (!stack.isEmpty()) {
                    int pop = stack.pop();
                    if (pop > 0)
                        score += pop;
                    else
                        break;
                }
                if (score == 0)
                    score++;
                else
                    score *= 2;
                stack.push(score);
            }
        }

        int ans = 0;
        for (int i : stack) {
            ans += i;
        }
        return ans;
    }

    public static void main(String[] args) {
        new ParenthesesScore().parenthesesScore("(()(()))");
    }
}
