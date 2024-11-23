package array;

import java.util.Comparator;
import java.util.PriorityQueue;

// Invariant : Max heap contains all the element lesser; and min-heap contains all the elements greater
public class LC295_FindMedian {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public LC295_FindMedian() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    // TC -> 5 * logN ( 3 heap additions and 2 deletions)
    // SC -> O(n) for pq to hold all elements
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }
        return 0.5 * (minHeap.peek() + maxHeap.peek());
    }

}
