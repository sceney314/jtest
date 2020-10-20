package leetcode.charfind;

/**
 * 最短回文串
 *
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 *
 * 示例 1:
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 *
 * 示例 2:
 * 输入: "abcd"
 * 输出: "dcbabcd"
 *
 * 2020-02-25 17:03
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        System.out.println("dcbabcd");
        String s = "aababababababa";
        System.out.println((new ShortestPalindrome()).shortestPalindrome(s));
        System.out.println((new ShortestPalindrome()).shortestPalindrome2(s));
    }

    /**
     * 双指针
     * @param s
     * @return
     */
    public String shortestPalindrome(String s){
        if (s == null || s.trim().length() < 1){
            return "";
        }

        char[] zifu = s.toCharArray();
        if (zifu.length < 2){
            return s;
        }

        int start = 0;

        for (int i = zifu.length - 1; i >= 0; i--){
            if (zifu[i] == zifu[start]){
                start++;
            }
        }

        if (start == zifu.length)
            return s;

        StringBuilder sb = new StringBuilder();
        char[] tmp = s.substring(start).toCharArray();
        for (int i = tmp.length - 1; i >= 0; i--){
            sb.append(tmp[i]);
        }

        return sb.toString() + shortestPalindrome(s.substring(0, start)) + s.substring(start);
    }


    /**
     * 结果正确，但是官方测试超时
     * @param s
     * @return
     */
    public String shortestPalindrome2(String s){
        if (s == null || s.trim().length() < 1){
            return "";
        }

        int n = s.length();
        if (n < 3){
            if (n == 1 || s.charAt(0) == s.charAt(1)){
                return s;
            }

            return s.charAt(1) + s;
        }

        char[] zifu = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int[] longest = centerPalindrome(s);
        int tail = n - 1;
        int right;
        if (longest[0] == longest[1]){
            right = 2;
            sb.append(s, 0, 2);
            sb.insert(0, zifu[1]);
        }else if(longest[0] == 0 && longest[1] == tail){
            return s;
        }else{
            sb.append(s, longest[0], longest[1] + 1);
            right = longest[1] == tail ? tail :longest[1] + 1;
        }

        while (right < n){
            sb.insert(0, zifu[right]);
            sb.append(zifu[right]);
            right++;
        }
        return sb.toString();
    }

    public int[] centerPalindrome(String s) {
        int[] res = new int[]{0, 0};
        int start = 0, end = 0;
        for (int i = 0; i < s.length() / 2 + 1; i++){
            // 假设长度是奇数, 得到回文长度
            int l1 = expandAroundCenter(s, i, i);

            // 假设长度是偶数, 得到回文长度
            int l2 = expandAroundCenter(s, i, i + 1);
            int l = Math.max(l1, l2);

            // 不管回文长度是奇数还是偶数，开始坐标都是长度-1/2
            if (l > end - start){
                start = i - (l - 1) / 2;
                end = i + l / 2;
                if (start == 0 && end > res[1]){
                    res[1] = end;
                }
            }
        }

        return res;
    }

    private int expandAroundCenter(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }
}
