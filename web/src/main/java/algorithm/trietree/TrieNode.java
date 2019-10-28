package algorithm.trietree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典树节点
 *
 * 2019-10-27 15:35
 */
@Data
public class TrieNode {
    // 有多少单词通过这个节点
    private Integer num;

    private String value;

    private boolean haveSon;

    // 是不是最后一个
    private boolean isEnd;

    // 所有的儿子节点
    private List<TrieNode> sons = new ArrayList<>();
}

