package array;

import java.util.TreeSet;

public class LC849_ClosestPerson {

    public static void main(String[] args) {
        int[] seats = {1,0,0,0,1,0,1};
        LC849_ClosestPerson problem = new LC849_ClosestPerson();
        System.out.println(problem.maxDistToClosest(seats));
    }

    public int maxDistToClosest(int[] seats) {
        int prev = -1;
        int next = 0;

        int len = seats.length;
        int i = 0;
        int max = 0;
        while (i < len) {
            if (seats[i] == 1) {
                prev = i;
            } else {
                while (next < len && seats[next] == 0 || next < i) {
                    next++;
                }
                int left = prev == -1 ? len : i - prev;
                int right = next == len ? len : next - i;
                max = Math.max(max, Math.min(left, right));
            }
            i++;
        }

        return max;
    }

}
