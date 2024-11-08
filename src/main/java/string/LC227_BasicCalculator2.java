package string;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/basic-calculator-ii
public class LC227_BasicCalculator2 {

    // Time -> O(n)
    // Space -> O(n)
    public int calculate(String s) {

        char op = '+';
        Deque<Integer> stack = new ArrayDeque<>();

        int i = 0;
        int curr = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            }
            if (i == s.length() - 1 || (!Character.isDigit(c) && !Character.isWhitespace(c))) {
                switch (op) {
                    case '+' :
                        stack.push(curr);
                        break;
                    case '-':
                        stack.push(-curr);
                        break;
                    case '*':
                        stack.push(stack.pop() * curr);
                        break;
                    case '/':
                        stack.push(stack.pop() / curr);
                        break;
                }
                curr = 0;
                op = c;
            }
            i++;
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    // Time -> O(n)
    // Space -> O(1)
    public int calculate_SpaceOptimized(String s) {

        int res = 0, curr = 0, last = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            }
            if (i == s.length() - 1 || (!Character.isDigit(c) && !Character.isWhitespace(c))) {
                switch (op) {
                    case '+':
                        res += last;
                        last = curr;
                        break;
                    case '-':
                        res += last;
                        last = -curr;
                        break;
                    case '*':
                        last = last * curr;
                        break;
                    case '/':
                        last = last / curr;
                }
                curr = 0;
                op = c;
            }
        }

        return res + last;
    }

    // Follow up with parenthesis -> https://leetcode.com/problems/basic-calculator/editorial/
}
