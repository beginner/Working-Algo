package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC126_WordLadder2 {

    public static void main(String[] args) {
        List<String> dict = List.of("hot","dot","dog","lot","log","cog");
        LC126_WordLadder2 problem = new LC126_WordLadder2();
        System.out.println(problem.findLadders("hit", "cog", dict));
    }


    List<List<String>> result = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        List<String> curr = new ArrayList<>();
        curr.add(beginWord);
        backtrack(beginWord, endWord, curr, visited, new HashSet<>(wordList));
        return result;
    }

    private void backtrack(String start, String end, List<String> curr, Set<String> visited, Set<String> dict) {
        if (start.equals(end)) {
            List<String> candidates = new ArrayList<>(curr);
            if (result.isEmpty() || result.get(result.size() - 1).size() > candidates.size()) {
                result = new ArrayList<>();
                result.add(candidates);
            } else if (result.get(result.size() - 1).size() == candidates.size()) {
                result.add(candidates);
            }
            return;
        }

        for (int i = 0; i < start.length(); i++) {
            int currentIndex = start.charAt(i) - 'a';
            for (int j = 0 ; j < 26; j++) {
                int nextIndex = (currentIndex + j) % 26;
                if (nextIndex == currentIndex) continue;
                String nextString = start.substring(0, i) + (char)('a' + nextIndex) + start.substring(i+1);
                if (dict.contains(nextString) && visited.add(nextString)) {
                    curr.add(nextString);
                    backtrack(nextString, end, curr, visited, dict);
                    curr.removeLast();
                    visited.remove(nextString);
                }
            }
        }



    }
}
