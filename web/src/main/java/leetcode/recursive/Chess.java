package leetcode.recursive;

/**
 * 棋盘覆盖
 * <p>
 * 2020-03-31 10:41
 */
public class Chess {
    /**
     * 棋盘覆盖
     *
     * @param size 棋盘大小
     * @param jx 奇异点 x 坐标
     * @param jy 奇异点 y 坐标
     * @param tag 填充标志
     * @return int[][]
     */
    public static int[][] chessBoard(int size, int jx, int jy, int tag) {

        if (size == 2) {

            int[][] re = new int[2][2];
            for (int x = 0; x < 2; x++){
                for (int y = 0; y < 2; y++){
                    if (!(x == jx && y == jy)){
                        re[x][y] = tag;
                    }
                }
            }
            return re;
        } else {
            ;
            if (jx < size / 2 && jy < size / 2) {
                //奇异点在左上角
                return matrixBlockPlus(chessBoard(size / 2, jx, jy, ++tag),
                        chessBoard(size / 2, size / 2 - 1, 0, ++tag),
                        chessBoard(size / 2, 0, size / 2 - 1, ++tag),
                        chessBoard(size / 2, 0, 0, ++tag));
            } else if (jx < size / 2 && jy >= size / 2) {
                //奇异点在右上角
                return matrixBlockPlus(chessBoard(size / 2, size / 2 - 1, size / 2 - 1, ++tag),
                        chessBoard(size / 2, jx, jy - size / 2, ++tag),
                        chessBoard(size / 2, 0, size / 2 - 1, ++tag),
                        chessBoard(size / 2, 0, 0, ++tag));
            } else if (jx >= size / 2 && jy < size / 2) {
                //奇异点在左下角
                return matrixBlockPlus(chessBoard(size / 2, size / 2 - 1, size / 2 - 1, ++tag),
                        chessBoard(size / 2, size / 2 - 1, 0, ++tag),
                        chessBoard(size / 2, jx - size / 2, jy, ++tag),
                        chessBoard(size / 2, 0, 0, ++tag));
            } else {
                return matrixBlockPlus(chessBoard(size / 2, size / 2 - 1, size / 2 - 1, ++tag),
                        chessBoard(size / 2, size / 2 - 1, 0, ++tag),
                        chessBoard(size / 2, 0, size / 2 - 1, ++tag),
                        chessBoard(size / 2, jx - size / 2, jy - size / 2, ++tag));
            }
        }
    }

    /**
     * 合并
     *
     * @param A11 分隔后左上模块
     * @param A12 分隔后右上模块
     * @param A21 分隔后左下模块
     * @param A22 分隔后右下模块
     * @return 合并后数组
     */
    public static int[][] matrixBlockPlus(int[][] A11, int[][] A12, int[][] A21, int[][] A22) {
        //将A11,A12,A21,A22按照左上，右上，左下，右下的顺序组合成一矩阵。
        if (A11[0].length + A12[0].length != A21[0].length + A22[0].length || A11.length + A21.length != A12.length + A22.length)
            return null;

        int[][] result = new int[A11.length + A21.length][A11[0].length + A12[0].length];
        for (int i = 0; i < A11.length + A21.length; i++){
            for (int j = 0; j < A11[0].length + A12[0].length; j++) {
                if (i < A11.length) {
                    if (j < A11[0].length) {
                        result[i][j] = A11[i][j];
                    } else {
                        result[i][j] = A12[i][j - A11[0].length];
                    }
                } else {
                    if (j < A12[0].length) {
                        result[i][j] = A21[i - A11.length][j];
                    } else {
                        result[i][j] = A22[i - A11.length][j - A12[0].length];
                    }
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[][] res = chessBoard(5, 2, 1, 0);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.printf("%d ", res[i][j]);
            }
            System.out.printf("\n");
        }
    }
}
