package array;

import java.util.HashMap;

public class LC62_UniquePath {

    HashMap<String, Integer> cache = new HashMap<>();

    public int uniquePaths(int m, int n) {
        return dfs(m, n, 0, 0);
    }

    private int dfs(int m, int n, int x, int y) {
        if (x >= m || y >= n) return 0;
        if (x == m -1 && y == n - 1) return 1;
        String key = x + "-" + y;
        if (cache.containsKey(key)) return cache.get(key);

        int numRight = dfs(m, n, x, y + 1);
        int numDown = dfs(m, n, x + 1, y);
        int total= numRight + numDown;
        cache.put(key, total);
        return total;
    }

}
