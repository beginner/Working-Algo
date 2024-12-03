package graph;

import java.util.PriorityQueue;

// Dijkstra
public class LC2577_MinimumTime {

    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        int[][] dirs = {
                {0,1},
                {0,-1},
                {1,0},
                {-1,0}
        };
        int m = grid.length;
        int n = grid[0].length;

        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        cost[0][0] = grid[0][0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0, 0, cost[0][0]});

        while (pq.size() > 0) {
            int[] p = pq.poll();
            int x = p[0];
            int y = p[1];
            int c = p[2];
            if (x == m - 1 && y == n -1) {
                return c;
            }

            //if (c > cost[x][y]) continue;

            for (int[] dir : dirs) {
                int nextX = dir[0] + x;
                int nextY = dir[1] + y;
                if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n) {
                    int wait = 0;
                    if ((grid[nextX][nextY] - c) % 2 == 0) wait = 1;

                    int nextCost = Math.max(grid[nextX][nextY] + wait, c + 1);
                    if (nextCost < cost[nextX][nextY]) {
                        cost[nextX][nextY] = nextCost;
                        pq.offer(new int[]{nextX, nextY, nextCost});
                    }
                }
            }
        }
        return -1;

    }
}
