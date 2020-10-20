package leetcode.sortalgorithm;

/**
 * 1370. 上升下降字符串
 * <p>
 * 2020-06-28 14:18
 */
public class SortString {
    public static void main(String[] args) {
        String con = "aaaabbbbcccc";
        SortString ss = new SortString();
        System.out.println(ss.sort(con));
    }
    public String sort(String s) {
        if(s == null || s.length() < 1){
            return "";
        }

        char[] zifu = s.toCharArray();
        int[] nums = new int[26];
        for(char c : zifu){
            int key = (int)c - 97;
            nums[key]++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 2; i++){

            // 从小到大
            for(int j = 0; j < nums.length; j++){
                if(nums[j] < 1){
                    continue;
                }
                sb.append((char)(j + 97));
                nums[j]--;
            }

            // 从大到小
            for(int k = nums.length - 1; k >= 0; k--){
                if(nums[k] < 1){
                    continue;
                }
                sb.append((char)(k + 97));
                nums[k]--;
            }
        }

        return sb.toString();
    }
}
