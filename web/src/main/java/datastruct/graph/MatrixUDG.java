package datastruct.graph;

import lombok.Data;


/**
 * 无向图 邻接矩阵
 * <p>
 * Date: 2020-08-10 11:27
 * Copyright (C), 2015-2020
 */
@Data
public class MatrixUDG {
    // 顶点集合
    private char[] mVexs;

    // 邻接矩阵
    private int[][] mMatrix;

    /*
     * 创建图(用已提供的矩阵)
     *
     * 参数说明：
     *     vexs  -- 顶点数组
     *     edges -- 边数组
     */
    public MatrixUDG(char[] vexs, char[][] edges) {

        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;
        int elen = edges.length;

        // 初始化"顶点"
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            mVexs[i] = vexs[i];
        }

        // 初始化"边"
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < elen; i++) {
            // 读取边的起始顶点和结束顶点位置
            int p1 = getPosition(edges[i][0]);
            int p2 = getPosition(edges[i][1]);

            mMatrix[p1][p2] = 1;
            mMatrix[p2][p1] = 1;
        }
    }

    /*
     * 返回ch位置
     */
    private int getPosition(char ch) {
        for (int i = 0; i < mVexs.length; i++)
            if (mVexs[i] == ch)
                return i;
        return -1;
    }

    /*
     * 打印矩阵队列图
     */
    public void print() {
        System.out.printf("Martix Graph:\n");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++)
                System.out.printf("%d ", mMatrix[i][j]);
            System.out.print("\n");
        }
    }

    /**
     * 返回顶点v的第一个邻接顶点的索引，失败则返回-1
     *
     * @param v 顶点下标
     * @return int
     */
    private int firstVertex(int v) {
        if (v < 0 || v > (mVexs.length - 1)) {
            return -1;
        }

        for (int i = 0; i < mVexs.length; i++) {
            if (mMatrix[v][i] == 1) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 返回顶点v相对于w的下一个邻接顶点的索引，失败则返回-1
     *
     * @param v 定点下标
     * @param w 已经访问过的标点
     * @return int
     */
    private int nextVertex(int v, int w) {
        if (v < 0 || v > (mVexs.length - 1) || w < 0 || w > (mVexs.length - 1)){
            return -1;
        }

        for (int i = w + 1; i < mVexs.length; i++){
            if (mMatrix[v][i] == 1){
                return i;
            }
        }

        return -1;
    }

    /**
     * 深度优先搜索遍历图的递归实现
     *
     * @param i 顶点位置
     * @param visited 是否访问过数组
     */
    private void DFS(int i, boolean[] visited) {

        visited[i] = true;
        System.out.printf("%c ", mVexs[i]);
        // 遍历该顶点的所有邻接顶点。若是没有访问过，那么继续往下走
        for (int w = firstVertex(i); w >= 0; w = nextVertex(i, w)) {
            if (!visited[w]) {
                DFS(w, visited);
            }
        }
    }

    /*
     * 深度优先搜索遍历图
     */
    public void DFS() {
        // 顶点访问标记
        boolean[] visited = new boolean[mVexs.length];
        // 初始化所有顶点都没有被访问
        for (int i = 0; i < mVexs.length; i++) {
            visited[i] = false;
        }

        System.out.print("DFS: ");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i]) {
                DFS(i, visited);
            }
        }
        System.out.print("\n");
    }

    /*
     * 广度优先搜索（类似于树的层次遍历）
     */
    public void BFS() {
        int head = 0;
        int rear = 0;
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
                System.out.printf("%c ", mVexs[i]);
                // 当前节点下标入队列
                queue[rear++] = i;
            }

            while (head != rear) {
                // 当前节点下标出队列
                int j = queue[head++];
                // 找出当前层次的下一层所有节点
                for (int k = firstVertex(j); k >= 0; k = nextVertex(j, k)) {
                    //k是为访问的邻接顶点
                    if (!visited[k]) {
                        visited[k] = true;
                        System.out.printf("%c ", mVexs[k]);
                        // 下一层入队
                        queue[rear++] = k;
                    }
                }
            }
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[][] edges = new char[][]{{'A', 'C'}, {'A', 'D'}, {'A', 'F'}, {'B', 'C'}, {'C', 'D'}, {'E', 'G'}, {'F', 'G'}};
        MatrixUDG pG = new MatrixUDG(vexs, edges);
        pG.print();   // 打印图
        System.out.println("----------");
        pG.DFS();     // 深度优先遍历
        System.out.println("----------");
        pG.BFS();     // 广度优先遍历
    }
}
