package graph;

import java.util.*;

public class LC269_AlienDictionary {

    public static void main(String[] args) {
        LC269_AlienDictionary problem = new LC269_AlienDictionary();
        String[] words = {"ac","ab","zc","zb"};
        System.out.println(problem.alienOrder(words));
    }

    // Input: words = ["wrt","wrf","er","ett","rftt"]
    // Output: "wertf"
    // Model as a graph problem - Topological sort
    public String alienOrder(String[] words) {
        // Create a adjacency list from source -> List<destination> ( destination is lexicographically smaller)
        // Do a topological sort using indegree
        HashMap<Character, List<Character>> adj = new HashMap<>();

        HashMap<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.put(c, 0);
                adj.put(c, new ArrayList<>());
            }
        }


        for (int i = 0; i < words.length - 1; i++) {
            int min = Math.min(words[i].length(), words[i+1].length());
            boolean found = false;
            for (int j = 0; j < min; j++) {
                if (words[i].charAt(j) != words[i+1].charAt(j)) {
                    adj.get(words[i].charAt(j)).add(words[i+1].charAt(j));
                    int existing = indegree.get(words[i+1].charAt(j));
                    indegree.put(words[i+1].charAt(j), existing + 1);
                    found = true;
                    break;
                }
            }
            if (!found && words[i].length() > words[i+1].length()) return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new ArrayDeque<>();
        for (final var entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                q.offer(entry.getKey());
            }
        }

        while (!q.isEmpty()) {
            char poll = q.poll();
            sb.append(poll);
            for (char c : adj.get(poll)) {
                indegree.put(c, indegree.get(c) - 1);
                if (indegree.get(c) == 0) {
                    q.offer(c);
                }
            }
        }
        if (sb.length() < indegree.size()) return "";
        return sb.toString();
    }
}
