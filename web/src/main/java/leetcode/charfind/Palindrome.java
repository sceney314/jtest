package leetcode.charfind;

/**
 * 最长回文子串
 *
 * @author zhengzp
 * 2019-12-30 15:52
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abacab"));
        System.out.println(dynamicPalindrome("abacab"));
        System.out.println(centerPalindrome("abacab"));
    }

    public static String centerPalindrome(String s) {
        if (s == null || s.equals("")){
            return s;
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++){
            // 假设长度是奇数, 得到回文长度
            int l1 = expandAroundCenter(s, i, i);

            // 假设长度是偶数, 得到回文长度
            int l2 = expandAroundCenter(s, i, i + 1);
            int l = Math.max(l1, l2);

            // 不管回文长度是奇数还是偶数，开始坐标都是长度-1/2
            if (l > end - start){
                start = i - (l - 1) / 2;
                end = i + l / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static String longestPalindrome(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }

                if (arr[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                }
            }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    public static String dynamicPalindrome(String s){
        if (s == null || s.length() < 2){
            return s;
        }
        char[] chars = s.toCharArray();
        String result = "";

        for (int i = 0; i < chars.length; i++){
            for (int j = chars.length - 1; j > i; j--){
                if (chars[j] != chars[i]){
                    continue;
                }

                // 判断是不是回文
                boolean palindrome = false;
                int l = i, r = j;
                while (l <= r){
                    if (chars[l] != chars[r]){
                        break;
                    }

                    if (l + 1 == r || l == r){
                        palindrome = true;
                        break;
                    }

                    l++;
                    r--;
                }

                if (!palindrome){
                    continue;
                }

                if (j - i + 1 > result.length()){
                    result = s.substring(i, j + 1);
                }
            }
        }

        if (result.length() < 1){
            return s.substring(0, 1);
        }

        return result;
    }
}
