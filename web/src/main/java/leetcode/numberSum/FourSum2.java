package leetcode.numberSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 四数相加 II
 *
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * @author zhengzp
 * 2019-12-11 15:42
 */
public class FourSum2 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2};
        int[] b = new int[]{-2,-1};
        int[] c = new int[]{-1,2};
        int[] d = new int[]{0,2};
        System.out.println(fourSumCount(a, b, c, d));
    }


    public static int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        int find = 0;
        Map<Integer, Integer> abMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int ab = a[i] + b[j];
                abMap.put(ab, abMap.getOrDefault(ab, 0) + 1);
            }
        }

        for (int k = 0; k < c.length; k++) {
            int c0 = 0 - c[k];
            for (int m = 0; m < d.length; m++) {
                int cd = c0 - d[m];
                if (abMap.containsKey(cd)) {
                    find += abMap.get(cd);
                }
            }
        }

        return find;
    }
}
