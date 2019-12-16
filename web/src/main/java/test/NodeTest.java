package test;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 节点列表
 *
 * @author zhengzp
 * 2019-12-16 10:23
 */
public class NodeTest {

    public static void main(String[] args) {
        Tree tree = new Tree("A");
        Tree b = new Tree("B");
        Tree c = new Tree("C");
        Tree d = new Tree("D");
        Tree e = new Tree("E");
        Tree f = new Tree("F");
        Tree g = new Tree("G");
        Tree h = new Tree("H");
        Tree i = new Tree("I");
        Tree j = new Tree("J");
        Tree k = new Tree("K");
        Tree l = new Tree("L");
        Tree m = new Tree("M");
        Tree n = new Tree("N");
        Tree o = new Tree("O");
        Tree p = new Tree("P");
        Tree q = new Tree("Q");
        Tree r = new Tree("R");
        Tree s = new Tree("S");
        Tree t = new Tree("T");
        tree.getSons().add(b);
        tree.getSons().add(c);
        tree.getSons().add(d);
        b.getSons().add(f);
        b.getSons().add(g);
        b.getSons().add(h);
        c.getSons().add(e);
        c.getSons().add(j);
        d.getSons().add(s);
        d.getSons().add(t);
        g.getSons().add(i);
        j.getSons().add(k);
        k.getSons().add(l);
        k.getSons().add(m);
        k.getSons().add(n);
        m.getSons().add(o);
        m.getSons().add(p);
        m.getSons().add(q);
        m.getSons().add(r);

        System.out.println(allNode(tree));
    }

    public static List<String> allNode(Tree tree){
        List<String> result = new ArrayList<>();
        Stack<Tree> stack = new Stack<>();
        while (tree != null || !stack.isEmpty()){
            while (tree != null){
                result.add(tree.getData());
                stack.push(tree);
                if (tree.getSons() != null && !tree.getSons().isEmpty()){
                    tree = tree.getSons().remove(0);
                }else {
                    break;
                }
            }
            tree = stack.peek();
            if (tree.getSons() == null || tree.getSons().size() <= 1){
                tree = stack.pop();
            }

            if (tree.getSons() != null && !tree.getSons().isEmpty()){
                tree = tree.getSons().remove(0);
            }else {
                tree = null;
            }

        }
        return result;
    }
}

@Data
class Tree{
    private String data;

    private List<Tree> sons = new ArrayList<>();

    public Tree() {
    }

    public Tree(String data) {
        this.data = data;
    }
}