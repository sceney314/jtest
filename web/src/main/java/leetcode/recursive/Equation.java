package leetcode.recursive;

import java.util.List;

/**
 * 整数划分
 * <p>
 * 2020-03-27 07:16
 */
public class Equation {

    public int equationCount(int n, int m){
        if (n < 0 || m < 0){
            return 0;
        }

        if (n == 1 || m == 1){
            return 1;
        }

        if (n < m){
            return equationCount(n, n);
        }

        if (n == m){
            return 1 + equationCount(n, m - 1);
        }

        return equationCount(n - m, m) + equationCount(n, m - 1);
    }

    public static void main(String[] args) {
        System.out.println((new Equation()).equationCount(5, 5));
    }
}
