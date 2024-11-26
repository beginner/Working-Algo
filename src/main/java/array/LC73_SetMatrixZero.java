package array;

public class LC73_SetMatrixZero {

    public void setZeroes(int[][] matrix) {
        //lessSpaceOptimized(matrix);
        spaceOptimized(matrix);
    }


    // TC -> O (m * n)
    // SC -> O(m + n)
    private void lessSpaceOptimized(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] rowsHasZero = new boolean[m];
        boolean[] colsHasZero = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowsHasZero[i] = true;
                    colsHasZero[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowsHasZero[i] || colsHasZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // SC -> O(1)
    // TC -> O (m * n)
    private void spaceOptimized(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean hasColZero = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j == 0) {
                        hasColZero = true;
                    } else {
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        // important to have this at last to avoid entire matrix being set to zero if matrix[0][0] = 0
        if (hasColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
