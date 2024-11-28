package string;

public class LC43_MultiplyString {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];
        int t = len1 + len2;

        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {

                int b = num2.charAt(j) - '0';

                int index = i + j + 1;
                int p = (a * b) + result[index];
                result[index] = p % 10;
                result[index - 1] += p / 10;

            }
        }
        int start = 0;
        while (start < result.length && result[start] == 0) start++;

        StringBuilder sb = new StringBuilder();
        while (start < result.length) {
            sb.append(result[start++]);
        }
        return sb.toString();
    }
}
