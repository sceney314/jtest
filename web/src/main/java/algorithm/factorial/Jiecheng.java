package algorithm.factorial;

/**
 * @author zhengzp
 * 2019-10-24 16:59
 */
public class Jiecheng {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(multi(n));
        System.out.println(trailingZeroes(n));
        System.out.println(tailZero(n));
    }

    public static int multi(int n){
        int i = 1, j = 1;
        while (j <= n){
            i = j * i;
            j++;
        }
        return i;
    }

    public static int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }

    public static int tailZero(int n){
        int i = 0;
        while (n > 4){
            n = n / 5;
            i += n;
        }
        return i;
    }
}
