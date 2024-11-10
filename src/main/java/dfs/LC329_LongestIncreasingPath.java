package dfs;

import java.util.HashMap;

public class LC329_LongestIncreasingPath {

    int[][] dirs = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };

    HashMap<String, Integer> cache = new HashMap<>();

    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, max(matrix, i, j));
            }
        }
        return max;
    }

    private int max(int[][] matrix, int row, int col) {
        if (!isValid(matrix, row, col)) return 0;
        String key = row + "-" + col;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int max = 1;

        for (int[] d : dirs) {
            int nx = d[0] + row;
            int ny = d[1] + col;
            if (isValid(matrix, nx, ny) && matrix[nx][ny] > matrix[row][col]) {
                int len = 1 + max(matrix, nx, ny);
                max = Math.max(max, len);
            }

        }
        cache.put(key, max);
        return max;

    }

    private boolean isValid(int[][] matrix, int row, int col) {
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        LC329_LongestIncreasingPath problem = new LC329_LongestIncreasingPath();
        System.out.println(problem.longestIncreasingPath(matrix));
    }
}
