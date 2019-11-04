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

    private String value;

    // 所有的儿子节点
    private List<TrieNode> sons = new ArrayList<>();

    // 层次
    private Integer level;
}

