package dfs;

import java.util.HashSet;
import java.util.Set;

public class LC79_WordSearch {


    public static void main(String[] args) {
        char[][] array = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCESEEEFS";
        LC79_WordSearch problem = new LC79_WordSearch();
        System.out.println(problem.exist(array, word));
    }

    int[][] dirs = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };

    public boolean exist(char[][] board, String word) {
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean result = dfs(board, word, visited, 0, i, j);
                if (result) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, Set<String> visited, int index, int x, int y) {
        if (index == word.length()) return true;
        String key = x + "-" + y;
        if (!isValid(board, x, y) ||
                word.charAt(index) != board[x][y] ||
                visited.contains(key)) {
            return false;
        }

        visited.add(key);
        for (int[] dir : dirs) {
            int nextX = dir[0] + x;
            int nextY = dir[1] + y;
            if (dfs(board, word, visited, index + 1, nextX, nextY)) {
                return true;
            }
        }
        visited.remove(key);
        return false;


    }

    private boolean isValid(char[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        return x >=0 && y >=0 && x < m && y < n;
    }

}
