package ting.leetcode.java.queueandstack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<String> recorder = new Stack<>();

        for (String token : tokens) {
            if (isNumeric(token)) {
                recorder.push(token);
            } else {
                String arg2 = recorder.pop();
                String arg1 = recorder.pop();
                int result = calculate(arg1, arg2, token);
                recorder.push(String.valueOf(result));
            }
        }

        String finalResult = recorder.pop();
        return Integer.parseInt(finalResult);
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int num = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static int calculate(String arg1, String arg2, String operator) {
        int int1 = Integer.parseInt(arg1);
        int int2 = Integer.parseInt(arg2);

        if ("+".equals(operator))
            return int1 + int2;
        if ("-".equals(operator))
            return int1 - int2;
        if ("*".equals(operator))
            return int1 * int2;
        if ("/".equals(operator))
            return int1 / int2;

        return 0;
    }


    public int evalRPNSecond(String[] tokens) {
        Stack<String> cache = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int result = Integer.parseInt(cache.pop()) + Integer.parseInt(cache.pop());
                cache.push(String.valueOf(result));
            } else if ("-".equals(token)) {
                String arg2 = cache.pop();
                String arg1 = cache.pop();
                int result = Integer.parseInt(arg1) - Integer.parseInt(arg2);
                cache.push(String.valueOf(result));
            } else if ("*".equals(token)) {
                int result = Integer.parseInt(cache.pop()) * Integer.parseInt(cache.pop());
                cache.push(String.valueOf(result));
            } else if ("/".equals(token)) {
                String arg2 = cache.pop();
                String arg1 = cache.pop();
                int result = Integer.parseInt(arg1) / Integer.parseInt(arg2);
                cache.push(String.valueOf(result));
            } else cache.push(token);
        }
        return Integer.parseInt(cache.pop());
    }
}
