package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2020-07-10 14:06
 */
public class Pailie {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, new Stack<Integer>(), new boolean[nums.length], ans);
        for (List<Integer> e : ans){
            System.out.println(e);
        }

    }

    public static void dfs(int[] nums, int depth, Stack<Integer> path, boolean[] used, List<List<Integer>> ans){
        if(depth == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }

            if(!path.isEmpty() && ((nums[i] == 3 && path.peek() == 5) || (nums[i] == 5 && path.peek() == 3))){
                return;
            }

            if(path.size() == 2 && path.peek() == 4){
                return;
            }



            used[i] = true;
            path.push(nums[i]);
            dfs(nums, depth + 1, path, used, ans);
            path.pop();
            used[i] = false;
        }
    }
}
