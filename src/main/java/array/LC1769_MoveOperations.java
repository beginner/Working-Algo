package array;

public class LC1769_MoveOperations {

    public int[] minOperations_BruteForce(String boxes) {
        int[] answer = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            char c = boxes.charAt(i);
            if (c == '1') {
                for (int j = 0; j < boxes.length(); j++) {
                    answer[j] += Math.abs(j - i);
                }
            }
        }
        return answer;
    }

    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int countLeft = 0, countRight = 0;
        int opsLeft = 0, opsRight = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] += opsLeft;
            countLeft += boxes.charAt(i) == '1' ? 1 : 0;
            opsLeft += countLeft;

            ans[n-1-i] += opsRight;
            countRight += boxes.charAt(n - 1 - i) == '1' ? 1 : 0;
            opsRight += countRight;
        }
        return ans;
    }

}
