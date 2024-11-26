package trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public char c;
    public Map<Character, TrieNode> neighbors;
    public boolean isWord;

    public TrieNode(char c) {
        this.c = c;
        neighbors = new HashMap<>();
    }
}
