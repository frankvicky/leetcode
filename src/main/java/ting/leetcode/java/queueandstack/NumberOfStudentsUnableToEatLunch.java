package ting.leetcode.java.queueandstack;

import java.util.LinkedList;

public class NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < students.length; i++) {
            queue.offer(students[i]);
            stack.offer(sandwiches[i]);
        }

        int count = students.length;
        while (count > 0 && !queue.isEmpty()) {
            int student = queue.poll();
            int sandwich = stack.peek();
            if (student != sandwich) {
                queue.offer(student);
                count--;
            } else {
                stack.pop();
                count = queue.size();
            }
        }

        return queue.size();
    }

    public int countStudentsWithArray(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for (int student : students) {
            count[student]++;
        }
        for (int sandwich : sandwiches) {
            if (count[sandwich] == 0) {
                break;
            }
            count[sandwich]--;
        }
        return count[0] + count[1];
    }
}
