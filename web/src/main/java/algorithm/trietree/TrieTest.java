package algorithm.trietree;

import java.util.Arrays;
import java.util.List;

/**
 * 字典树
 *
 * 2019-10-27 15:35
 */
public class TrieTest {
    public static void main(String[] args) {
        String blackStr = "上门,老赖,公安,高利贷,小额贷款公司,吸毒,金融机构,骚扰,无赖,出车祸,交警,耍赖,死亡,自杀,疯," +
                "警官,警察局,打死,神经,曝光,脑子,民警,贱,黑社会,老子,武警,上访,所长,SB,记者,跳楼,矫情,2B,混社会,牛逼,特警," +
                "杂种,贱人,屌,畜生,不想活,拽,被车撞死,扯淡,王八蛋,暴力,二货,割腕,你大爷,给脸,猪头,死全家,撸网贷,想死,车撞死,跳河," +
                "法警,笨蛋,脑残,裸条,废物,瞎搞,坑爹,败类,二百五,臭不要脸,什么玩意,死去,裸照,肉偿,坑爹的,不活了,老东西,无脑,煞笔," +
                "砍他,傻叉,龟儿子,羞辱,货色,胁迫,白痴,砍刀,一起死,瓜娃子,禽兽,作死,有枪,搞你,傻B,二皮脸,我们是银行,上门,老赖,公安," +
                "高利贷,小额贷款公司,吸毒,金融机构,骚扰,无赖,出车祸,交警,耍赖,死亡,自杀,疯,警官,警察局,打死,神经,曝光,脑子,民警,贱," +
                "黑社会,老子,武警,上访,所长,SB,记者,跳楼,矫情,2B,混社会,牛逼,特警,杂种,贱人,屌,畜生,不想活,拽,被车撞死,扯淡,王八蛋," +
                "暴力,二货,割腕,你大爷,给脸,猪头,死全家,撸网贷,想死,车撞死,跳河,法警,笨蛋,脑残,裸条,废物,瞎搞,坑爹,败类,二百五,臭不要脸," +
                "什么玩意,死去,裸照,肉偿,坑爹的,不活了,老东西,无脑,煞笔,砍他,傻叉,龟儿子,羞辱,货色,胁迫,白痴,砍刀,一起死,瓜娃子,禽兽," +
                "作死,有枪,搞你,傻B,二皮脸,我们是银行";

        List<String> blackList = Arrays.asList(blackStr.split(","));

        String dd = "手动阀";
        System.out.println(dd.charAt(dd.length() - 1));
    }


    public static void itree(TrieNode tree, String word){
        if (word == null || word.trim().length() < 1){
            return;
        }

        int i = 0;
        while (i < word.length()){
            addLeft(tree, word.substring(i, i + 1));
            i++;
        }
    }

    public static void addLeft(TrieNode tree, String data){

    }
}
