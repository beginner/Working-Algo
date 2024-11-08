package array;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/description
public class LC215_LargestKElement {

    // N -> length of nums
    // Time complexity -> O(Nlogk)
    // Space complexity -> O(k)
    public int findKthLargest_UsingHeap(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }

    // To optimize the time complexity, use a flavor of counting sort
    // if negatives not allowed
    public int findKthLargest_NoNegatives(int[] nums, int k) {
        int len = nums.length;

        int max = 0;
        for (int n : nums) {
            max = Math.max(max, n);
        }

        int[] counts = new int[max + 1];
        for (int n : nums) {
            counts[n]++;
        }

        int[] sorted = new int[len];
        int write = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                int t = counts[i];
                while (t-- > 0) {
                    sorted[write++] = i;
                }
            }
        }
        return sorted[len - k];
    }

    // Negatives allowed
    // N -> length of nums array
    // M -> max - min
    // Time -> O(N + M)
    // Space -> O(M) for counts array
    public int findKthLargest_CountingSort_Negatives(int[] nums, int k) {
        int len = nums.length;

        int max = 0;
        int min = 0;
        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        int[] counts = new int[max - min + 1]; // Offset by min
        for (int n : nums) {
            counts[n - min]++;
        }

        int[] sorted = new int[len];
        int write = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                int t = counts[i];
                while (t-- > 0) {
                    sorted[write++] = i + min;
                }
            }
        }
        return sorted[len - k];
    }

    // We do not need to create a sorted array
    public int findKthLargest(int[] nums, int k) {
        int max = 0;
        int min = 0;
        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        int[] counts = new int[max - min + 1];
        for (int n : nums) {
            counts[n - min]++;
        }

        for (int i = counts.length - 1; i >= 0; i--) {
            k -= counts[i];
            if (k <= 0) return i + min;
        }
        return 0;
    }

    // Quick select has worst case complexity of O(n ^ 2 ). Average is O(n)
    public int findKthLargest_QuickSelect(List<Integer> nums, int k) {
        int pivotIndex = (int)(Math.random() * nums.size());
        int pivotElement = nums.get(pivotIndex);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            if (num > pivotElement) {
                left.add(num);
            } else if (num < pivotElement) {
                right.add(num);
            } else {
                mid.add(num);
            }
        }
        if (left.size() >= k) {
            return findKthLargest_QuickSelect(left, k);
        }
        if (left.size() + mid.size() < k) {
            return findKthLargest_QuickSelect(right, k - left.size() - mid.size());
        }
        return pivotElement;
    }


}
