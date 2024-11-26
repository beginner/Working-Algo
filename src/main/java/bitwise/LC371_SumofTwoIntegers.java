package bitwise;

// https://www.youtube.com/watch?v=gVUrDV4tZfY
public class LC371_SumofTwoIntegers {

    // TC -> O(1)
    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1;
            a = a ^ b;
            b = tmp;
        }

        return a;
    }

}
