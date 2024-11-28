package graph;

import java.util.*;

public class LC127_WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashMap<String, Set<String>> map = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i+1);
                map.putIfAbsent(pattern, new HashSet<>());
                map.get(pattern).add(word);
            }
        }
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int count = 1;
        while (q.size() > 0) {
            int size = q.size();

            for (int i = 0 ; i < size; i++) {
                String poll = q.poll();
                if (poll.equals(endWord)) return count;

                for (int j = 0; j < poll.length(); j++) {
                    String pattern = poll.substring(0, j) + "*" + poll.substring(j+1);
                    Set<String> candidates = map.getOrDefault(pattern, new HashSet<>());
                    for (String candidate : candidates) {
                        if (visited.add(candidate)) {
                            q.offer(candidate);
                        }

                    }

                }
            }
            count++;
        }
        return 0;

    }

}
