package array;

// Similar LC43
public class LC66_AddOne {

    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];

        int carry = 1;

        int j = result.length - 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int a = carry + digits[i];
            result[i + 1] = a % 10;
            result[i] += a / 10;
            carry = a / 10;
        }

        int start = 0;
        while (start < result.length && result[start] == 0) start++;

        int[] answer = new int[result.length - start];
        int k = 0;
        while (start < result.length) {
            answer[k++] = result[start++];
        }
        return answer;
    }

}
