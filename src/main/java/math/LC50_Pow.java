package math;

public class LC50_Pow {

    // Since in each recursive call, we divide by half.
    // Time -> O(logn)
    // Space -> 0(logn)
    private double recurse(double x, long n) {
        if (n < 0) return recurse(1/x, -n);
        if (n == 0) return 1;
        if (n == 1) return x;

        if (n % 2 == 0) {
            return recurse(x * x, n / 2);
        }
        return x * recurse(x * x, (n-1)/2);
    }

    // Time -> O(logn)
    // Space -> O(1)
    private double iterative(double x, int n) {
        if (n < 0) {
            n = -1 * n;
            x = 1/x;
        }

        double result = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                result = result * x;
                n--;
            }
            n /= 2;
            x = x * x;
        }
        return result;
    }


}
