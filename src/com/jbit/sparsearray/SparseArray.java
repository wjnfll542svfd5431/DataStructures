package com.jbit.sparsearray;

/**
 *二维数组转稀疏数组
 * 稀疏数组转回二维数组
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个11x11二维数组
        int[][] chessArr1 = new int[11][11];
        //0代表没有棋子，1代表白起，2代表黑棋
        chessArr1[1][2] =1;
        chessArr1[2][3] =2;
        chessArr1[3][4] =1;
        for (int[] row : chessArr1) {
            for (int data: row){
                System.out.printf("%d\t",data);
            }
            System.out.println("");
        }
        //计算得出非零个数
        int sum=0;
        for (int i=0;i<chessArr1.length;i++){
            for(int j=0;j<chessArr1.length;j++){
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int[][] sparse = new int[sum+1][3];
        sparse[0][0] = chessArr1.length;
        sparse[0][1] = chessArr1.length;
        sparse[0][2] = sum;
        //插入稀疏数组行
        int count=0;
        for (int i=0; i<chessArr1.length;i++){
            for (int j=0;j<chessArr1.length;j++){
                if(chessArr1[i][j] != 0){
                    count++;
                    sparse[count][0]=i;
                    sparse[count][1]=j;
                    sparse[count][2]=chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println();
        for (int i=0;i<sparse.length;i++){
            System.out.printf("%d\t%d\t%d\t\n", sparse[i][0], sparse[i][1], sparse[i][2]);
        }

        //创建恢复后的稀疏数组
        int[][] chessArr2 = new int[sparse[0][0]][sparse[0][1]];

        for (int j=1;j<sparse.length;j++){
            chessArr2[sparse[j][0]][sparse[j][1]]=sparse[j][2];
        }
        System.out.println("恢复后的二维数组");

        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
