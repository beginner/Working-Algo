package string;

// https://leetcode.com/problems/valid-palindrome-ii/description
public class LC680_ValidPalindrome2 {

    // Time -> O ( len(s) * mismatches)
    public boolean validPalindrome(String s) {
        return helper(s, 0, s.length() - 1, 1);
    }

    private boolean helper(String s, int left, int right, int mismatches) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return mismatches > 0 && (helper(s, left +1, right, mismatches - 1) || helper(s, left, right - 1, mismatches - 1));
            }
            left++;
            right--;
        }
        return true;
    }


}
