package graph;

import java.util.PriorityQueue;

// Dijkstra
public class LC1631_MinimumPath {

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dirs = {
                {0,1},
                {0,-1},
                {1,0},
                {-1,0},
        };

        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        int max = 0;
        cost[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0, 0, 0});

        while (pq.size() > 0) {
            int[] poll = pq.poll();
            int x = poll[0];
            int y = poll[1];
            int c = poll[2];
            max = Math.max(max, c);
            if (x == m - 1 && y == n - 1) return max;

            for (int[] dir : dirs) {
                int x1 = x + dir[0];
                int y1 = y + dir[1];
                if (isValid(heights, x1, y1)) {
                    int diff = Math.abs(heights[x][y] - heights[x1][y1]);
                    if (diff < cost[x1][y1]) {
                        cost[x1][y1] = diff;
                        pq.offer(new int[]{x1, y1, diff});
                    }
                }
            }

        }

        return -1;
    }

    private boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && y >=0 && x < grid.length && y < grid[0].length;
    }

    public int minimumEffortPath_AnotherVariation(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dirs = {
                {0,1},
                {0,-1},
                {1,0},
                {-1,0},
        };

        boolean[][] visited = new boolean[m][n];


        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0, 0, 0});

        while (pq.size() > 0) {
            int[] poll = pq.poll();
            int x = poll[0];
            int y = poll[1];
            int c = poll[2];

            if (x == m - 1 && y == n - 1) return c;
            if (visited[x][y]) continue;
            visited[x][y] = true;
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (isValid(heights, nx, ny) && !visited[nx][ny]) {

                    int d = Math.abs(heights[nx][ny] - heights[x][y]);
                    int nextDiff = Math.max(d, c);
                    pq.offer(new int[]{nx, ny, nextDiff});
                }
            }


        }

        return -1;
    }

}
