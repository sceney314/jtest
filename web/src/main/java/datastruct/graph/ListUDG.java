package datastruct.graph;

/**
 * 无向图 邻接表
 * Date: 2020-08-10 11:45
 * Copyright (C), 2015-2020
 */
public class ListUDG {
    // 邻接表中表对应的链表的顶点对象
    private static class ENode {
        // 该边所指向的顶点的位置
        int ivex;

        // 指向下一条弧的指针
        ENode nextEdge;
    }

    // 邻接表中表的顶点对象
    private static class VNode {
        // 顶点信息
        char data;

        // 指向第一条依附该顶点的弧
        ENode firstEdge;
    }

    // 顶点数组
    private final VNode[] mVexs;


    /*
     * 创建图(用已提供的矩阵)
     *
     * 参数说明：
     *     vexs  -- 顶点数组
     *     edges -- 边数组
     */
    public ListUDG(char[] vexs, char[][] edges) {
        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;
        int elen = edges.length;

        // 初始化"顶点"
        mVexs = new VNode[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            mVexs[i] = new VNode();
            mVexs[i].data = vexs[i];
        }

        // 初始化"边"
        for (char[] edge : edges) {
            // 读取边的起始顶点和结束顶点
            int p1 = getPosition(edge[0]);
            int p2 = getPosition(edge[1]);
            // 初始化node1
            ENode node1 = new ENode();
            node1.ivex = p2;
            // 将node1链接到"p1所在链表的末尾"
            if (mVexs[p1].firstEdge == null) {
                mVexs[p1].firstEdge = node1;
            } else {
                linkLast(mVexs[p1].firstEdge, node1);
            }

            // 初始化node2
            ENode node2 = new ENode();
            node2.ivex = p1;
            // 将node2链接到"p2所在链表的末尾"
            if (mVexs[p2].firstEdge == null) {
                mVexs[p2].firstEdge = node2;
            } else {
                linkLast(mVexs[p2].firstEdge, node2);
            }
        }
    }

    /**
     * 将node节点链接到list的最后
     *
     * @param list 链表
     * @param node 添加到链表的节点
     */
    private void linkLast(ENode list, ENode node) {
        ENode p = list;

        while (p.nextEdge != null){
            p = p.nextEdge;
        }
        p.nextEdge = node;
    }

    /**
     * 返回ch位置
     *
     * @param ch 顶点字符
     * @return int
     */
    private int getPosition(char ch) {
        for (int i = 0; i < mVexs.length; i++){
            if (mVexs[i].data == ch){
                return i;
            }
        }
        return -1;
    }

    /*
     * 打印矩阵队列图
     */
    public void print() {
        System.out.print("List Graph:\n");
        for (int i = 0; i < mVexs.length; i++) {
            System.out.printf("%d(%c): ", i, mVexs[i].data);
            ENode node = mVexs[i].firstEdge;
            while (node != null) {
                System.out.printf("%d(%c) ", node.ivex, mVexs[node.ivex].data);
                node = node.nextEdge;
            }
            System.out.print("\n");
        }
    }


    /**
     * 广度优先搜索（类似于树的层次遍历）
     */
    public void bfs() {
        int head = 0, rear = 0;
        // 辅组队列
        int[] queue = new int[mVexs.length];
        // 顶点访问标记
        boolean[] visited = new boolean[mVexs.length];
        for (int i = 0; i < mVexs.length; i++){
            visited[i] = false;
        }

        System.out.print("BFS: ");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.printf("%c ", mVexs[i].data);
                // 入队列
                queue[rear++] = i;
            }

            while (head != rear) {
                // 出队列
                int j = queue[head++];
                ENode node = mVexs[j].firstEdge;
                while (node != null) {
                    int k = node.ivex;
                    if (!visited[k]) {
                        visited[k] = true;
                        System.out.printf("%c ", mVexs[k].data);
                        queue[rear++] = k;
                    }
                    node = node.nextEdge;
                }
            }
        }
        System.out.print("\n");
    }

    /**
     * 深度优先搜索遍历图的递归实现
     *
     * @param i 图节点位置
     * @param visited 是否访问过表示
     */
    private void dfsByIndex(int i, boolean[] visited) {
        ENode node;

        visited[i] = true;
        System.out.printf("%c ", mVexs[i].data);
        node = mVexs[i].firstEdge;
        while (node != null) {
            if (!visited[node.ivex]){
                dfsByIndex(node.ivex, visited);
            }
            node = node.nextEdge;
        }
    }

    /**
     * 深度优先搜索遍历图
     */
    public void dfs() {
        // 顶点访问标记
        boolean[] visited = new boolean[mVexs.length];
        // 初始化所有顶点都没有被访问
        for (int i = 0; i < mVexs.length; i++){
            visited[i] = false;
        }

        System.out.print("DFS: ");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i]){
                dfsByIndex(i, visited);
            }
        }
        System.out.print("\n");
    }


    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[][] edges = new char[][]{{'A', 'C'}, {'A', 'D'}, {'A', 'F'}, {'B', 'C'}, {'C', 'D'}, {'E', 'G'}, {'F', 'G'}};
        ListUDG pG = new ListUDG(vexs, edges);

        pG.print();   // 打印图
        pG.dfs();     // 深度优先遍历
        pG.bfs();     // 广度优先遍历
    }
}
