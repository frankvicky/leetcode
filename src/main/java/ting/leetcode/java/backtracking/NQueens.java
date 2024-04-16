package ting.leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<List<String>> answer = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        ArrayList<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }

        backtrack(board, 0);
        return answer;
    }

    void backtrack(List<String> board, int row) {
        if (row == board.size()) {
            answer.add(new ArrayList<>(board));
            return;
        }

        int length = board.get(row).length();
        for (int col = 0; col < length; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }

            StringBuilder currentRow = new StringBuilder(board.get(row));
            currentRow.setCharAt(col, 'Q');
            board.set(row, currentRow.toString());

            backtrack(board, row + 1);

            currentRow.setCharAt(col, '.');
            board.set(row, currentRow.toString());
        }
    }

    boolean isValid(List<String> board, int row, int col) {
        int length = board.size();
        // 检查列是否有皇后互相冲突
        for (int i = 0; i <= row; i++) {
            if (board.get(i).charAt(col) == 'Q')
                return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < length; i--, j++) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }
}
