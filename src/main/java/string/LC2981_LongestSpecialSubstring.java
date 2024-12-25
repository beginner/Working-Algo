package string;

import java.util.HashMap;

public class LC2981_LongestSpecialSubstring {

    public static void main(String[] args) {
        String temp = "abcdef";
        LC2981_LongestSpecialSubstring problem = new LC2981_LongestSpecialSubstring();
        System.out.println(problem.maximumLength(temp));
    }

    public int maximumLength(String s) {
        return bruteForce(s);
    }


    private int bruteForce(String s) {
        HashMap<String, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder curr = new StringBuilder();
            for (int j = i ; j < s.length(); j++) {
                if (curr.length() == 0 || curr.charAt(curr.length() - 1) == s.charAt(j)) {
                    curr.append(s.charAt(j));
                } else {
                    break;
                }
                String temp = curr.toString();
                freqMap.put(temp, freqMap.getOrDefault(temp, 0) + 1);
            }

        }

        int max = -1;
        for (final var entry : freqMap.entrySet()) {
            if (entry.getValue() >= 3) {
                max = Math.max(max, entry.getKey().length());
            }
        }
        return max;


    }

}
