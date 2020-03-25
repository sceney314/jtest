package algorithm.binarytree;

/**
 * 2020-03-25 18:47
 */
public class AVLTest {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9};
        AVLTree tree = new AVLTree();
        for (int n : nums){
            tree.add(n);
        }

        System.out.println("---------------中序遍历---------------");
        System.out.println(tree.inOrder());

        System.out.println("---------------删除节点 13---------------");
        tree.del(5);
        System.out.println(tree.inOrder());
    }
}
