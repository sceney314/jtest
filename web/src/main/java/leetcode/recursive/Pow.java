package leetcode.recursive;

/**
 * 50. Pow(x, n)
 * <p>
 * 2020-04-03 05:59
 */
public class Pow {
    public double myPow(double x, int n) {
        if (n < 0){
            x = 1/x;
            n = -n;
        }

        return fastPow(x, n);
    }

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0d;
        }

        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow2(double x, int n) {
        long m = n;
        if (m < 0){
            x = 1 / x;
            m = -m;
        }

        double res = 1;
        while (m != 0){
            if ((m % 2) == 1) {
                res = res * x;
            }
            x *= x;
            m /= 2;
        }

        return res;
    }

    public double myPow3(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println((new Pow()).myPow(2.00000, -2147483648));
        System.out.println((new Pow()).myPow2(2.00000, -2147483648));
        System.out.println((new Pow()).myPow3(2.00000, -2147483648));
    }
}
