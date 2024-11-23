package array;

// https://leetcode.com/problems/diagonal-traverse/
public class LC498_DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[] result = new int[rows * cols];
        int write = 0;
        boolean going_up = true;
        int row = 0, col = 0;

        while (write < result.length) {
            if (going_up) {
                while (row >= 0 && col < cols) {
                    result[write++] = mat[row][col];
                    row -= 1;
                    col += 1;
                }
                if (col == cols) {
                    col -= 1;
                    row += 2;
                } else {
                    row += 1;
                }
                going_up = false;
            } else {
                while (row < rows && col >= 0) {
                    result[write++] = mat[row][col];
                    row += 1;
                    col -= 1;
                }
                if (row == rows) {
                    row -= 1;
                    col += 2;
                } else {
                    col += 1;
                }
                going_up = true;
            }
        }

        return result;
    }

}
