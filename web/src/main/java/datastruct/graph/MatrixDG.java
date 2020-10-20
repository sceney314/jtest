package datastruct.graph;

/**
 * 有向图 邻接矩阵
 * <p>
 * Date: 2020-08-12 15:12
 * Copyright (C), 2015-2020
 */
public class MatrixDG {
    // 顶点集合
    private char[] mVexs;

    // 邻接矩阵
    private int[][] mMatrix;


    public MatrixDG(char[] vexs, char[][] edges) {

        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;
        int elen = edges.length;

        // 初始化"顶点"
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++){
            mVexs[i] = vexs[i];
        }

        // 初始化"边"
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < elen; i++) {
            // 读取边的起始顶点和结束顶点
            int p1 = getPosition(edges[i][0]);
            int p2 = getPosition(edges[i][1]);

            mMatrix[p1][p2] = 1;
        }
    }

    /*
     * 返回ch位置
     */
    private int getPosition(char ch) {
        for(int i=0; i<mVexs.length; i++)
            if(mVexs[i]==ch)
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
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[][] edges = new char[][]{{'A', 'B'}, {'B', 'C'}, {'B', 'E'}, {'B', 'F'}, {'C', 'E'}, {'D', 'C'}, {'E', 'B'}, {'E', 'D'}, {'F', 'G'}};
        MatrixDG pG = new MatrixDG(vexs, edges);
        pG.print();   // 打印图
    }
}
