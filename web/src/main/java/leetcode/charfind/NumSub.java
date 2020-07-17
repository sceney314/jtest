package leetcode.charfind;

public class NumSub {
    public int mod = 1000000007;

    public static void main(String[] args) {
        NumSub sub = new NumSub();
        String s = "111";
        System.out.println(sub.subNum(s));
    }

    public int subNum(String s) {
        int ans = 0, i = 0, len = s.length(), left = 0;
        boolean find = false;
        while(i < len){
            if(s.charAt(i) == '0'){
                if(find){
                    find = false;
                    int tmp = i - left;
                    ans += sub(tmp);
                    ans = ans > mod ? ans/mod : ans;
                }
                left = ++i;
            }else{
                i++;
                if (!find)
                    find = true;
            }
        }

        if(find){
            int tmp = len - left;
            ans += sub(tmp);
        }

        return ans;
    }

    private int sub(int n){
        if(n < 3){
            return n <= 1 ? 1 : 3;
        }
        int ans = n + 1;
        int i = 2;
        while(i < n){
            ans += (n - i) + 1;
            i++;
        }
        return ans > mod ? ans/mod : ans;
    }
}
