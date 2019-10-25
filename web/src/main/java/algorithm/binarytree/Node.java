package algorithm.binarytree;

import lombok.Data;

/**
 * 节点
 *
 * @author zhengzp
 * 2019-10-24 20:54
 */
@Data
public class Node {
    // 左孩子
    private Node left;

    // 右孩子
    private Node right;

    // 父节点
    private Node parent;

    // 值
    private String data;

    public Node() {
    }

    public Node(String data) {
        this.data = data;
    }


}
