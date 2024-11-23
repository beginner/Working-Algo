package string;

public class LC424_LongestRepeating {


    // TC -> O(26 * N) --> O(N)
    // SC -> O(26) -> O(1)
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int max = 0;

        int[] freq = new int[26];

        while (right < s.length()) {
            freq[s.charAt(right) - 'A']++;
            // currentWindow length = right - left + 1
            // number of replacements = current Window length - max char freq
            if (right - left + 1 - getMostFrequency(freq) > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;


    }

    private int getMostFrequency(int[] freq) {
        int max = 0;
        for (int f : freq) {
            max = Math.max(f, max);
        }
        return max;
    }


}
