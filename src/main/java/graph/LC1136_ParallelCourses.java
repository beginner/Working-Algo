package graph;

import java.util.*;

public class LC1136_ParallelCourses {

    public int minimumSemesters(int n, int[][] relations) {
        int[] indegree = new int[n];
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] rel : relations) {
            // a -> b
            int a = rel[0] - 1;
            int b = rel[1] - 1;
            map.putIfAbsent(a, new HashSet<>());
            map.get(a).add(b);
            indegree[b]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int semesters = 0;
        int coursesCompleted = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int course = q.poll();
                coursesCompleted++;
                Set<Integer> dep = map.getOrDefault(course, new HashSet<>());
                for (int d : dep) {
                    indegree[d]--;
                    if (indegree[d] == 0) {
                        q.offer(d);
                    }
                }
            }
            semesters++;
        }

        // for (int i = 0; i < indegree.length; i++) {
        //     if (indegree[i] != 0) return -1;
        // }

        return n == coursesCompleted ? semesters : -1;
    }

}
