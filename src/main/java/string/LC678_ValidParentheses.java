package string;

import java.util.ArrayDeque;
import java.util.Deque;

// Similar to LC 2116
public class LC678_ValidParentheses {

    // TC & SC -> O(N)
    public boolean checkValidString(String s) {
        Deque<Integer> stars = new ArrayDeque<>();
        Deque<Integer> parentheses = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                stars.push(i);
            } else if (c == '(') {
                parentheses.push(i);
            } else {
                if (stars.isEmpty() && parentheses.isEmpty()) return false;

                if (parentheses.size() > 0) parentheses.pop();
                else stars.pop();
            }
        }

        while (parentheses.size() > 0) {
            if (stars.size() == 0) return false;
            if (stars.pop() < parentheses.pop()) return false;
        }
        return true;
    }

    public boolean checkValidStringOptimized(String s) {
        int open = 0;
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                open++;
            } else {
                open--;
            }

            if (s.charAt(s.length() - 1 - i) == ')' || s.charAt(s.length() - 1 - i) == '*') {
                close++;
            } else {
                close--;
            }
            if (open < 0 || close < 0) return false;
        }
        return true;
    }

}
