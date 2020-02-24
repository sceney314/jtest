package leetcode.charfind;


/**
 * 回文子串
 *
 * @author zhengzp
 * 2019-12-30 21:07
 */
public class PalindromeCount {
    public static void main(String[] args) {
        System.out.println(countSubstring3("bbccaacacdbdbcbcbbbcbadcbdddbabaddbcadb"));
        System.out.println(countSubstrings("aaa"));
//        System.out.println(countSubstrings2("bbccaacacdbdbcbcbbbcbadcbdddbabaddbcadb"));
    }

    public static int countSubstring3(String s) {
        if (s == null || s.equals("")){
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++){
            // 假设长度是奇数, 得到回文长度
            int l1 = expandAroundCenter(s, i, i);
            // 假设长度是偶数, 得到回文长度
            int l2 = expandAroundCenter(s, i, i + 1);
            ans += l1 + l2;
        }

        return ans;
    }

    private static int expandAroundCenter(String s, int left, int right){
        int d = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            d++;
        }

        return d;
    }

    public static int countSubstrings2(String S) {
        int N = S.length(), ans = 0;
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    public static int countSubstrings(String S) {
        char[] A = new char[2 * S.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int t = 2;
        for (char c: S.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }

        int[] Z = new int[A.length];
        int center = 0, right = 0;
        for (int i = 1; i < Z.length - 1; ++i) {
            if (i < right)
                Z[i] = Math.min(right - i, Z[2 * center - i]);
            // 小技巧，如果默认半径是 1 不是回文一定是填充字符：#
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1])
                Z[i]++;
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        int ans = 0;
        for (int v: Z) ans += (v + 1) / 2;
        return ans;
    }
}
