package string;

public class LC224_BasicCalculator {

    public static void main(String[] args) {
        LC224_BasicCalculator problem = new LC224_BasicCalculator();
        System.out.println(problem.calculate("1-     -2"));
    }

    public int calculate(String s) {
        int curr_num = 0;
        int last_num = 0;
        char op = '+';
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr_num = curr_num * 10 + (c - 'a');
            }
            if (i == s.length() - 1 || (!Character.isDigit(c) && !Character.isWhitespace(c) && c != '(' && c != ')')) {
                result += last_num;
                if (op == '+') {
                    last_num = curr_num;
                }
                if (op == '-') {
                    last_num = -curr_num;
                }
                curr_num = 0;
                op = c;
            }
        }
        return result + last_num;
    }

}
