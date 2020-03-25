package algorithm.binarytree.huffman;

/**
 * 2020-03-25 20:20
 */
public class HuffmanTest {
    private static final int a[] = {5, 6, 8, 7, 15};

    public static void main(String[] args) {
        // 资料：https://www.cnblogs.com/skywang12345/p/3706833.html#anchor2
        int i;
        Huffman tree;
        System.out.print("== 添加数组: ");
        for (i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        // 创建数组a对应的Huffman树
        tree = new Huffman(a);
        System.out.print("\n== 前序遍历: ");
        tree.preOrder();
        System.out.print("\n== 中序遍历: ");
        tree.inOrder();
        System.out.print("\n== 后序遍历: ");
        tree.postOrder();
        System.out.println();
        System.out.println("== 树的详细信息: ");
        tree.print();
        // 销毁二叉树
        tree.destroy();
    }
}
