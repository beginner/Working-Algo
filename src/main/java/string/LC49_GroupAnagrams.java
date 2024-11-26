package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC49_GroupAnagrams {

    // N being number of strings
    // K -> length of largest string
    // TC -> O( N * K)
    // SC -> O (N * K)
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] f = freq(s);
            String hash = Arrays.toString(f);
            map.putIfAbsent(hash, new ArrayList<>());
            map.get(hash).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private int[] freq(String s) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) {
            f[c - 'a']++;
        }
        return f;
    }
}
