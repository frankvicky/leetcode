package ting.leetcode.java.arrays101;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int matrixLength = matrix.length;
        for (int i = 0; i < matrixLength; i++) {
            for (int j = i; j < matrixLength; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] row : matrix) {
            int lastIndex = row.length - 1;
            for (int i = 0; i < row.length / 2; i++) {
                int temp = row[i];
                row[i] = row[lastIndex - i];
                row[lastIndex - i] = temp;
            }
        }
    }
}
