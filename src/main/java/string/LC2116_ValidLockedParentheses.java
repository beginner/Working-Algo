package string;

// Similar to LC 678
public class LC2116_ValidLockedParentheses {

    public boolean canBeValid(String s, String locked) {
        int len = s.length();
        // if (len % 2 == 1) return false;
        int open = 0;
        int close = 0;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            char t = locked.charAt(i);

            if (c == '(' || t == '0') {
                open++;
            } else {
                open--;
            }
            if (s.charAt(len - 1 - i) == ')' || locked.charAt(len - 1 - i) == '0') {
                close++;
            } else {
                close--;
            }
            if (open < 0 || close < 0) return false;
        }
        return len % 2 == 0;
    }

}
