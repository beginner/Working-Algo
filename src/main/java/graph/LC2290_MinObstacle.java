package graph;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LC2290_MinObstacle {

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0,0},{0,1,0,1,0},{0,0,0,1,0}};
        LC2290_MinObstacle problem = new LC2290_MinObstacle();
        System.out.println(problem.minimumObstacles(grid));
    }

    int[][] dirs = {
            {0,1},
            {0, -1},
            {1,0},
            {-1,0}
    };

    int min = Integer.MAX_VALUE;

    // TC -> O (m * n)
    // SC -> O(m * n)
    private int bfs(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        cost[0][0] = grid[0][0];

        Tuple start = new Tuple(0, 0, cost[0][0]);

        Deque<Tuple> q = new ArrayDeque<>();
        q.offer(start);

        while (q.size() > 0) {
            Tuple poll = q.poll();
            if (poll.x == m - 1 && poll.y == n - 1) return poll.numObstacles;

            for (int[] dir : dirs) {
                int nextX = dir[0] + poll.x;
                int nextY = dir[1] + poll.y;
                if (isValid(grid, nextX, nextY) && cost[nextX][nextY] == Integer.MAX_VALUE) {
                    int obstacles = poll.numObstacles + grid[nextX][nextY];
                    cost[nextX][nextY] = obstacles;
                    if (obstacles == poll.numObstacles) {
                        q.addFirst(new Tuple(nextX, nextY, obstacles));
                    } else {
                        q.addLast(new Tuple(nextX, nextY, obstacles));
                    }
                }
            }


        }
        return Integer.MAX_VALUE;
    }
    public int minimumObstacles(int[][] grid) {
//        Set<String> visited = new HashSet<>();
//        visited.add("0-0");
//        backtrack(grid, 0, 0, new AtomicInteger(0), visited);
//        return min;

        return dijkstra(grid);
    }

    // TC -> O (m * n log (m * n))
    // SC -> O(m * n)
    private int dijkstra(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        cost[0][0] = grid[0][0];

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.numObstacles, b.numObstacles));

        pq.offer(new Tuple(0, 0, cost[0][0]));

        while (pq.size() > 0) {
            Tuple poll = pq.poll();
            if (poll.x == m - 1 && poll.y == n - 1) {
                return poll.numObstacles;
            }

            for (int[] dir : dirs) {
                int nextX = dir[0] + poll.x;
                int nextY = dir[1] + poll.y;
                if (isValid(grid, nextX, nextY)) {
                    int obstacle = poll.numObstacles + grid[nextX][nextY];
                    if (obstacle < cost[nextX][nextY]) {
                        cost[nextX][nextY] = obstacle;
                        pq.offer(new Tuple(nextX, nextY, obstacle));
                    }
                }
            }
        }
        return cost[m - 1][n - 1];
    }

    class Tuple {
        int x;
        int y;
        int numObstacles;

        public Tuple(int x, int y, int numObstacles) {
            this.x = x;
            this.y = y;
            this.numObstacles = numObstacles;
        }
    }

    private void backtrack(
            int[][] grid,
            int x,
            int y,
            AtomicInteger numRemoved,
            Set<String> visited) {
        int m = grid.length;
        int n = grid[0].length;
        if (x == m - 1 && y == n - 1) {
            min = Math.min(min, numRemoved.get());
            return;
        }

        for (int[] dir : dirs) {
            int nextX = dir[0] + x;
            int nextY = dir[1] + y;
            String key = nextX + "-" + nextY;
            if (isValid(grid, nextX, nextY) && visited.add(key)) {
                boolean isObstacle = grid[nextX][nextY] == 1;
                if (isObstacle) numRemoved.incrementAndGet();
                backtrack(grid, nextX, nextY, numRemoved, visited);
                if (isObstacle) numRemoved.decrementAndGet();
                visited.remove(key);
            }
        }
    }


    private boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
