package leetcode.stack;

/**
 * 2020-05-26 11:38
 */
public class KthGrammar {
    public static void main(String[] args) {
        System.out.println(kthGrammar(1, 1));
    }

    public static int kthGrammar(int N, int K) {
        String res = grammar("0", N, N, K);
        return (int)res.indexOf(K - 1);
    }

    private static String grammar(String bt, int c, int n, int k){
        if(c <= 1){
            return "0";
        }else if(c == 2){
            return "01";
        }

        bt = grammar(bt, --c, n, k);

        StringBuilder sb = new StringBuilder(bt);
        char[] cs = bt.toCharArray();
        for(int i = cs.length / 2; i < cs.length; i++){
            if(cs[i] == '0'){
                sb.append("01");
            }else{
                sb.append("10");
            }
        }

        return sb.toString();
    }
}
