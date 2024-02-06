package ting.leetcode.java.hashtable;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudokuBrutal(char[][] board) {
        Set<Character> characters = new HashSet<>();
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == '.')
                    continue;
                if (!characters.add(cell)) {
                    return false;
                }
            }
            characters.clear();
        }


        for (int columnIndex = 0; columnIndex < board.length; columnIndex++) {
            for (char[] row : board) {
                char cell = row[columnIndex];
                if (cell == '.')
                    continue;
                if (!characters.add(cell))
                    return false;
            }
            characters.clear();
        }

        for(int boxRow = 0; boxRow < 3; boxRow++) {
            for(int boxCol = 0; boxCol < 3; boxCol++) {
                for(int cellRow = 0; cellRow < 3; cellRow++) {
                    for(int cellCol = 0; cellCol < 3; cellCol++) {
                        char cell = board[boxRow*3 + cellRow][boxCol*3 + cellCol];
                        if (cell == '.')
                            continue;
                        if (!characters.add(cell))
                            return false;
                    }
                }
                characters.clear();
            }
        }

        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        // 創建一個HashSet存儲已見過的數字與其所在的行、列和區塊
        Set<String> seen = new HashSet<>();
        // 使用雙重for迴圈來執行二維棋盤的遍歷
        for (int i=0; i<9; ++i) { // i代表行數
            for (int j=0; j<9; ++j) { // j代表列數
                char number = board[i][j]; // 從棋盤中取出字符
                // 判斷取到的字符是否為數字，若是 '.' 則跳過
                if (number != '.')
                    // 檢查是否可以將該數字的行、列、區塊資訊添加到seen中
                    // 如果有任何重複(已經添加過的數字相同且位置相同)，那麼添加操作會失敗並返回false，隨即函數返回false
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        // 若遍歷過棋盤所有元素且沒有返回false，則表示該數獨棋盤有效，返回true
        return true;
    }

    public static void main(String[] args) {

        char[][] testData = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

        System.out.println(new ValidSudoku()
                .isValidSudokuBrutal(testData));
    }
}
