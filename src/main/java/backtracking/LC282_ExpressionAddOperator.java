package backtracking;

// Not optimized

public class LC282_ExpressionAddOperator {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("2+2*3");
        LC282_ExpressionAddOperator problem = new LC282_ExpressionAddOperator();
        System.out.println(problem.calculateValue(sb));
    }

    private int calculateValue(StringBuilder temp) {
        int result = 0;
        int curr = 0, last = 0;
        char op = '+';
        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            }
            if (i == temp.length() - 1 || !Character.isDigit(c)) {
                if (op == '+') {
                    result += last;
                    last = curr;
                }
                if (op == '-') {
                    result += last;
                    last = -curr;
                }
                if (op == '*') {
                    last = last * curr;
                }
                curr = 0;
                op = c;
            }
        }

        return result + last;
    }
}
