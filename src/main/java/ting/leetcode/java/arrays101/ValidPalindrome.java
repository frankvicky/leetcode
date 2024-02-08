package ting.leetcode.java.arrays101;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        List<Character> characters = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c))
                characters.add(Character.toLowerCase(c));
        }

        int mid = characters.size() / 2;

        for (int i = 0; i < mid ; i++) {
            if (characters.get(i) != characters.get(characters.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeTwoPointer(String s) {
        int startPointer = 0;
        int lastPointer = s.length() - 1;

        while (startPointer <= lastPointer) {
            char front = s.charAt(startPointer);
            char back = s.charAt(lastPointer);

            if (!Character.isLetterOrDigit(front))
                startPointer++;
            else if (!Character.isLetterOrDigit(back))
                lastPointer--;
            else {
                if (Character.toLowerCase(front) != Character.toLowerCase(back))
                    return false;

                startPointer++;
                lastPointer--;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindromeTwoPointer("A man, a plan, a canal: Panama"));
    }
}
