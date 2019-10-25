package algorithm.binarytree;

import java.util.List;

/**
 * 二叉树遍历
 *
 * @author zhengzp
 * 2019-10-24 20:56
 */
public class TreeTest {

    public static void main(String[] args) {
        Node tree = tree();
        List<String> list = firstTraversing(tree);
        if (list == null || list.size() < 1){
            System.out.println("列表为空");
        }else{
            String result = String.join(",", list);
            System.out.println(result);
        }
    }

    public static Node tree(){
        Node d = new Node("D");
        Node c = new Node("C");
        Node b = new Node("B");
        Node a = new Node("A");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node k = new Node("K");

        a.setLeft(b);
        a.setRight(e);
        b.setRight(c);
        b.setParent(a);
        c.setLeft(d);
        c.setParent(b);
        d.setParent(c);
        e.setRight(f);
        e.setParent(a);
        f.setLeft(g);
        f.setParent(e);
        g.setLeft(h);
        g.setRight(k);
        g.setParent(f);
        k.setParent(g);
        h.setParent(g);

        return a;
    }

    /**
     * 先序遍历
     *
     * @param tree 二叉树
     * @return List
     */
    public static List<String> firstTraversing(Node tree){
        return null;
    }


}
