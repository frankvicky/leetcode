package ting.leetcode.java.queueandstack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        LinkedList<Employee> stack = new LinkedList<>();
        HashMap<Integer, Employee> table = new HashMap<>();
        HashSet<Employee> visited = new HashSet<>();

        for (Employee employee : employees) {
            table.put(employee.id, employee);
        }

        Employee target = table.get(id);
        stack.push(target);

        int ans = target.importance;
        while (!stack.isEmpty()) {
            Employee pop = stack.pop();
            for (Integer subordinate : pop.subordinates) {
                Employee employee = table.get(subordinate);
                if (!visited.contains(employee)) {
                    stack.push(employee);
                    visited.add(employee);
                    ans += employee.importance;
                }
            }
        }

        return ans;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
