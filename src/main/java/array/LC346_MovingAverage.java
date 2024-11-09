package array;

// Time -> O(1)
// Space -> O(N)gt
public class LC346_MovingAverage {

    int total = 0;
    int count = 0;
    int[] arr;
    int head = 0;

    public LC346_MovingAverage(int size) {
        arr = new int[size];
    }

    public double next(int val) {
        count = Math.min(arr.length, count + 1);
        total -= arr[head];
        arr[head] = val;
        head++;
        if (head == arr.length) head = 0;
        total += val;
        return (1.0 * total)/ count;
    }
}
