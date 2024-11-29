package graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC480_SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int len = nums.length;
        double[] result = new double[nums.length - k + 1 ];
        for (int i = 0; i < len ; i++) {
            if (i >= k) {
                int numToRemove = nums[i - k];
                if (numToRemove <= maxHeap.peek()) {
                    maxHeap.remove(numToRemove);
                } else {
                    minHeap.remove(numToRemove);
                }
            }
            balance(maxHeap, minHeap, nums[i]);
            if (i >= k - 1) {
                int total = maxHeap.size() + minHeap.size();
                if (total % 2 == 0) { // even
                    result[i - k + 1] = ((double) minHeap.peek() + maxHeap.peek()) / 2;
                } else {
                    result[i - k + 1] = maxHeap.peek();
                }
            }
        }

        return result;
    }

    private void balance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

}
