package trie;

public class LC208_ImplementTrie {
    TrieNode root;

    public LC208_ImplementTrie() {
        root = new TrieNode('/');
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!curr.neighbors.containsKey(c)) {
                curr.neighbors.put(c, new TrieNode(c));
            }
            TrieNode child = curr.neighbors.get(c);
            curr = child;
            if (i == word.length() - 1) {
                child.isWord = true;
            }

        }
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!curr.neighbors.containsKey(c)) {
                return false;
            }
            TrieNode child = curr.neighbors.get(c);
            curr = child;
            if (i == word.length() - 1) {
                return child.isWord;
            }
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (!curr.neighbors.containsKey(c)) {
                return false;
            }
            TrieNode child = curr.neighbors.get(c);
            curr = child;
        }
        return true;
    }
}
