package string;

import java.util.HashMap;

public class LC76_MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ABBCBB";
        String t = "BB";
        LC76_MinimumWindowSubstring problem = new LC76_MinimumWindowSubstring();
        System.out.println(problem.minWindow(s, t));
    }

    // Sliding window problem
    public String minWindow(String s, String t) {
        // 1. Create freq map of string 't'
        // 2. Iterate the string 's'
            // 2.1 Populate the actual frequency map for matching character
            // 2.2 Any time the frequency count matches, increment the 'matched' counter
        // 3 Until the matched count matches, contract the window
        HashMap<Character, Integer> required = new HashMap<>();
        for (char c : t.toCharArray()) {
            int existing = required.getOrDefault(c, 0);
            required.put(c, existing + 1);
        }
        HashMap<Character, Integer> actual = new HashMap<>();

        int min = Integer.MAX_VALUE;

        int left = 0, right = 0;
        int matched = 0;
        int ansLeft = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (!required.containsKey(c)) {
                right++;
                continue;
            }

            actual.put(c, actual.getOrDefault(c, 0) + 1);

            if (actual.get(c).equals(required.get(c))) {
                matched++;
            }
            while (matched == required.size()) {
                int temp = right - left + 1;
                if (temp < min) {
                    ansLeft = left;
                    min = temp;
                }
                char q = s.charAt(left);
                if (actual.containsKey(q)) {
                    actual.put(q, actual.get(q) - 1);
                    if (actual.get(q) < required.get(q)) {
                        matched--;
                    }
                }
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(ansLeft, ansLeft + min);
    }
}
