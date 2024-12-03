package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC394_DecodeString {

    public String decodeString(String s) {
        return singleStack(s);

    }

    private String usingTwoStack(String s) {
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        Deque<Integer> countStack = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();
        int curr_num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curr_num = curr_num * 10 + (c - '0');
            } else if (c == '[') {
                stringStack.push(curr);
                curr = new StringBuilder();
                countStack.push(curr_num);
                curr_num = 0;
            } else if (c == ']') {
                StringBuilder top = stringStack.pop();
                int count = countStack.pop();
                while (count-- > 0) {
                    top.append(curr);
                }
                curr = top;
            } else {
                curr.append(c);
            }
        }


        return curr.toString();
    }

    private static String singleStack(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                stack.pop(); // pop '['
                int num = 0;
                int base = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num = (stack.pop() - '0') * base + num;
                    base *= 10;
                }
                while (num -- > 0) {
                    for (int j = sb.length() - 1; j >=0; j--) {
                        stack.push(sb.charAt(j));
                    }
                }

            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
