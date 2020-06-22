package leetcode.greedy;

/**
 * 55. 跳跃游戏
 * 2020-06-17 19:42
 */
public class CanJumpGame {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,0};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2){
            return true;
        }
        boolean flag = false;
        int st = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] > st){
                st = 0;
                flag = true;
            }else{
                st++;
                flag = false;
            }
        }

        if(st > 0 && nums[0] >= nums.length - 1){
            return true;
        }

        return flag;
    }
}
