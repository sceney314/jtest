package leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 全排列
 * <p>
 * 2020-06-28 16:09
 */
public class Permute {

    public static void main(String[] args) {
        Permute p = new Permute();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(p.perm(nums));
    }

    public List<List<Integer>> perm(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        // perm(nums, 0, nums.length - 1, res);
        boolean[] used = new boolean[nums.length];
        Stack<Integer> path = new Stack<>();
        dfs(nums, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int depth, Stack<Integer> path, boolean[] used,  List<List<Integer>> res){
        // 递归终结条件
        if(depth == nums.length){
            res.add(new ArrayList(path));
            return;
        }

        // 递归逻辑
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            path.push(nums[i]);
            used[i] = true;
            dfs(nums, depth + 1, path, used, res);
            used[i] = false;
            path.pop();
        }
    }
}
