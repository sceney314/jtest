package algorithm.binarytree;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 二叉树遍历
 *
 * @author zhengzp
 * 2019-10-24 20:56
 */
public class TreeTest {

    public static void main(String[] args) {
        Node tree = tree();

        System.out.println("先序(遍历)遍历答案：A,B,D,G,C,E,F,H");
        String result = String.join(",", firstTraversing(tree));
        System.out.println("先序(循环)遍历结果：" + result);
        List<String> first = new ArrayList<>();
        firstRecursive(tree, first);
        String result2 = String.join(",", first);
        System.out.println("先序(递归)遍历结果：" + result2);
        System.out.println("");

        System.out.println("中序(遍历)遍历答案：D,B,G,A,E,C,H,F");
        String middle = String.join(",", middleTraversing(tree));
        System.out.println("中序(循环)遍历结果：" + middle);
        List<String> middleData = new ArrayList<>();
        middleRecursive(tree, middleData);
        String middle2 = String.join(",", middleData);
        System.out.println("中序(递归)遍历结果：" + middle2);
        System.out.println("");


        System.out.println("后序(遍历)遍历答案：D,G,B,E,H,F,C,A");
        String behind = String.join(",", behindTraversing(tree));
        System.out.println("后序(循环)遍历结果：" + behind);
        List<String> behindData = new ArrayList<>();
        behindRecursive(tree, behindData);
        String behind2 = String.join(",", behindData);
        System.out.println("后序(递归)遍历结果：" + behind2);
        System.out.println("");

        System.out.println("层次遍历答案：[[\"A\"],[\"B\",\"C\"],[\"D\",\"G\",\"E\",\"F\"],[\"H\"]]");
        System.out.println("层次遍历结果：" + JSON.toJSONString(levelTraversing(tree)));
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

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(g);
        c.setLeft(e);
        c.setRight(f);
        f.setLeft(h);

        return a;
    }

    /**
     * 先序遍历（非递归）
     * 先根节点、再左孩子、再右孩子
     *
     * @param tree 二叉树
     * @return List
     */
    public static List<String> firstTraversing(Node tree){
        List<String> data = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        while (tree != null || !nodeStack.isEmpty()){
            while (tree != null){
                data.add(tree.getData());
                nodeStack.push(tree);
                tree = tree.getLeft();
            }
            tree = nodeStack.pop().getRight();
        }
        return data;
    }

    /**
     * 先序遍历（递归）
     * 先根节点、再左孩子、再右孩子
     *
     * @param node 二叉树
     * @param data 数据
     */
    public static void firstRecursive(Node node, List<String> data){
        if (node == null){
            return;
        }
        data.add(node.getData());
        firstRecursive(node.getLeft(), data);
        firstRecursive(node.getRight(), data);
    }

    /**
     * 中序遍历（非递归）
     * 先左孩子、再根节点、再右孩子
     *
     * @param tree 二叉树
     * @return List
     */
    public static List<String> middleTraversing(Node tree){
        List<String> data = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        while (tree != null || !nodeStack.isEmpty()){
            while (tree != null){
                nodeStack.push(tree);
                tree = tree.getLeft();
            }

            Node node = nodeStack.pop();
            data.add(node.getData());
            tree = node.getRight();
        }

        return data;
    }

    /**
     * 中序遍历(递归)
     * 先左孩子、再根节点、再右孩子
     *
     * @param node 二叉树
     * @param data 结果集
     */
    public static void middleRecursive(Node node, List<String> data){
        if (node == null){
            return;
        }
        middleRecursive(node.getLeft(), data);
        data.add(node.getData());
        middleRecursive(node.getRight(), data);
    }


    /**
     * 后续遍历（非递归）
     * 先左孩子、再右孩子、再根节点
     *
     * @param tree 二叉树
     * @return List
     */
    public static List<String> behindTraversing(Node tree){
        List<String> data = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        while (tree != null || !nodeStack.isEmpty()){
            while (tree != null){
                nodeStack.push(tree);
                if (tree.getLeft() != null){
                    tree = tree.getLeft();
                }else{
                    tree = tree.getRight();
                }
            }

            if (!nodeStack.isEmpty()){
                tree = nodeStack.pop();
                data.add(tree.getData());
            }

            while (!nodeStack.isEmpty() && nodeStack.peek().getRight() == tree) {
                tree = nodeStack.pop();
                data.add(tree.getData());
            }

            if (!nodeStack.isEmpty()) {
                tree = nodeStack.peek().getRight();
            } else {
                tree = null;
            }
        }

        return data;
    }

    /**
     * 后续遍历（递归）
     * 先左孩子、再右孩子、再根节点
     *
     * @param node 二叉树
     * @param data 结果集
     */
    public static void behindRecursive(Node node, List<String> data){
        if (node == null){
            return;
        }

        behindRecursive(node.getLeft(), data);
        behindRecursive(node.getRight(), data);
        data.add(node.getData());
    }

    /**
     * BFS广度优先遍历
     *
     * @param node 二叉树
     * @return List
     */
    public static List<List<String>> levelTraversing(Node node){
        if (node == null){
            return new ArrayList<>();
        }

        List<List<String>> data = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            int count = queue.size();
            List<String> level = new ArrayList<>();
            while (count > 0){
                Node temp = queue.peek();
                queue.poll();

                level.add(temp.getData());

                if(temp.getLeft() != null){
                    queue.add(temp.getLeft());
                }

                if(temp.getRight() != null){
                    queue.add(temp.getRight());
                }
                count--;
            }
            data.add(level);
        }

        return data;
    }


}
