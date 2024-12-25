package array;

public class LC3152_SpecialArray {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;

        int[] prefix = new int[n];
        prefix[0] = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == nums[i-1] % 2) {
                prefix[i] = prefix[i - 1] + 1;
            } else {
                prefix[i] = prefix[i-1];
            }
        }

        int q = queries.length;
        boolean[] result = new boolean[q];

        for (int i = 0; i < q; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];
            result[i] = (prefix[end] - prefix[start]) == 0;

        }

        return result;
    }

}
