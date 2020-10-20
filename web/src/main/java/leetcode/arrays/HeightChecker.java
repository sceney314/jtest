package leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class HeightChecker {
    public static void main(String[] args) {
        HeightChecker c = new HeightChecker();
        System.out.println(c.checker(new int[]{1,2,2,2,2,2,1,2,2,1}));
    }

    public int checker(int[] heights) {
        int ans = 0;
        Set<Integer> idx = new HashSet<>();
        for(int i = 0, k = 0, j = 0; i < heights.length; i++){
            if(i < heights.length - 1 &&  heights[i] <= heights[i + 1]){
                continue;
            }else if(i == heights.length - 1){
                continue;
            }


            for(j = i + 1, k = i; j < heights.length; j++){
                if(heights[j] <= heights[k]){
                    k = j;
                }
            }

            if(!idx.contains(k)){
                ans++;
            }
            if(!idx.contains(i)){
                ans++;
            }
            int tmp = heights[k];
            heights[k] = heights[i];
            heights[i] = tmp;
            idx.add(i);
            idx.add(k);
        }

        return ans;
    }
}
