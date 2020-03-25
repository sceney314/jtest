package leetcode.tree;

import algorithm.binarytree.BinarySearchTree;

/**
 * 2020-03-25 14:31
 */
public class BSTTest {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(9);
        tree.add(5);
        tree.add(20);
        tree.add(15);
        tree.add(30);
        tree.add(13);
        tree.add(18);
        tree.add(10);
        tree.add(12);
        tree.add(11);
        tree.add(14);
        tree.add(16);
        tree.add(19);
        System.out.println(tree.inOrder());

        System.out.println("--------------删除元素--------------");
        tree.del(18);
        System.out.println(tree.inOrder());
    }
}
