package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * <p>
 * 2020-04-06 22:00
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "", n, n);
        return res;
    }

    private void generate(List<String> res, String subList, int left, int right){
        if (left == 0 && right == 0){
            res.add(subList);
            return;
        }

        if (left > 0){
            generate(res, subList + "(", left - 1, right);
        }
        if (right > left){
            generate(res, subList + ")", left, right - 1);
        }
    }

    private void generateAll(List<List<String>> res, char[] zifu, int left, int right){
        if (left == right){
            List<String> son = new ArrayList<>();
            res.add(son);
            for (int k = 0; k <= right; k++){
                son.add(String.valueOf(zifu[k]));
            }
            return;
        }

        for (int m = left; m <= right; m++){
            swap(zifu, m, right);
            generateAll(res, zifu, m + 1, right);
            swap(zifu, m, right);
        }
    }

    private void swap(char[] res, int left, int right){
        char temp = res[left];
        res[left] = res[right];
        res[right] = temp;
    }

    public static void main(String[] args) {
        String zifu = "((()))";
        List<List<String>> res = new ArrayList<>();
        (new GenerateParenthesis()).generateAll(res, zifu.toCharArray(), 0, 5);
        for (List<String> temp : res){
            System.out.println(temp);
        }
    }

}
