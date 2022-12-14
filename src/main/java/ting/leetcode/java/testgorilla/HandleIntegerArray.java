package ting.leetcode.java.testgorilla;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HandleIntegerArray {
    public static Integer odd_even_product( Integer[] my_list ) {
        var result = Arrays.stream(my_list).reduce((acc, next) -> acc * next).get();
        if ((result & 1) == 0)
            return Arrays.stream(my_list).reduce(Integer::sum).get();
        else
            return 0;
    }

    public static String password( String[] passwords, String checkString ) {
        int firstDigit = Character.getNumericValue(checkString.charAt(0));
        String middleWord = checkString.substring(1, 4);
        int digitTotalShouldBe = Character.getNumericValue(checkString.charAt(4));
        StringBuilder reverse = new StringBuilder();
        char ch;

        for (int i = 0; i < middleWord.length(); i++) {
            ch = middleWord.charAt(i);
            reverse.insert(0, ch);
        }


        for (String password : passwords) {
            var upperCaseCount = 0;
            var digitTotal = 0;
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    upperCaseCount++;
                }

                if (Character.isDigit(c)) {
                    digitTotal += Character.getNumericValue(c);
                }
            }

            if (upperCaseCount != firstDigit) continue;
            if (digitTotal != digitTotalShouldBe) continue;
            if (!password.contains(reverse.toString())) continue;
            return password;
        }

        return null;
    }
}
