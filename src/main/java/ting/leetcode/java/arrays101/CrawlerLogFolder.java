package ting.leetcode.java.arrays101;

public class CrawlerLogFolder {
    public static int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if ("../".equals(log)) {
                if (depth > 0)
                    depth--;
            } else if ("./".equals(log)) {

            } else {
                depth++;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        minOperations(new String[]{"./", "../", "./"});
    }
}
