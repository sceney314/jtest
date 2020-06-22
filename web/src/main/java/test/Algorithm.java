package test;

import java.util.*;

/**
 * 2020-06-15 15:35
 */
public class Algorithm {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,1,1,0,0,0,0},{1,1,1,1,1,1,0},{0,0,0,0,0,0,0},{1,1,1,0,0,0,0},{1,1,1,1,1,1,1}};
        System.out.println(Arrays.toString(kWeakestRows(mat, 4)));

        String[] a = new String[]{"zyx","wvu","tsr"};
        System.out.println(minDeletionSize(a));
    }

    public static int minDeletionSize(String[] A) {
        for(int i = 0; i < A[0].length(); i++){
            for(int j = 1; j < A.length; j++){
                if(A[j - 1].charAt(i) > A[j].charAt(i)){
                    return i;
                }
            }
        }

        return 0;
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> result = new ArrayList<>();
        for(int i = 0; i < mat.length; i++){
            int left = 0, right = mat[i].length - 1;
            while(left <= right){
                int mid = (left + right) / 2;
                if(mat[i][mid] == 1){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            result.add(new int[]{i, left});
        }

        result.sort(Comparator.comparingInt(o -> o[1]));

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = result.get(i)[0];
        }

        return res;
    }
}
