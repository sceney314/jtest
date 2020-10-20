package leetcode.median;

/**
 * 2020-05-29 10:24
 */
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(2147395599));
        System.out.println(46339);
    }

    public static int sqrt(int x) {
        if(x <= 1){
            return x;
        }
        int left = 0;
        int right = x;
        int min = -1;
        int max = -1;
        for(;;){
            int gen = (left + right) / 2;
            int tmp = gen > 46340 ? Integer.MAX_VALUE : gen * gen;
            if(gen > 46340 || tmp > x){
                max = gen;
                right = gen - 1;
            }else if(tmp < x){
                min = gen;
                left = gen + 1;
            }else{
                return gen;
            }

            if(max - min <= 1){
                return min;
            }
        }
    }

}
