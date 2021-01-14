package com.jbit.recursion;


/**
 * @Author 王江南
 * @ClasssName MiGong
 * @Date 2020/9/15 13:36
 * @Version 1.0
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //设置左右两面墙
        for(int i = 0;i < 8;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置上下两面墙
        for(int i = 0;i < 7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //设置挡板
        map[3][1]=1;
        map[3][2]=1;

        //输出地图情况
        for(int i = 0;i < 8;i++){
           for(int j = 0;j < 7;j++){
               System.out.print(map[i][j]+" ");
           }
           System.out.println("");
       }
        System.out.println("");
        System.out.println("小球走过的路线");
        setWay2(map,1,1);
        for(int i = 0;i < 8;i++){
            for(int j = 0;j < 7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println("");
        }
    }

    /**
     * 设定约束，走过的路表示为2
     * 下标6,5为2表示已近到了终点
     *  下-右
     * @param map
     * @return
     */
    public static boolean setWay(int[][] map,int i,int j){
        //到终点
        if(map[6][5] == 2){
            return true;
        }else{
            if(map[i][j] == 0){
                map[i][j]=2;
                if(setWay(map,i+1,j)){
                    return true;
                }
                if(setWay(map,i,j+1)){
                    return true;
                }
            }else{
                return false;
            }
        }
        return false;
    }

    public static boolean setWay2(int [][] map,int i,int j){
        if(map[6][5] == 2){
            return true;
        }else{
            if(map[i][j] == 0){
                map[i][j] =2;
                if(setWay2(map,i,j+1)){
                    return true;
                }
                if(setWay2(map,i+1,j)){
                    return true;
                }
            }else{
                return false;
            }
        }
        return false;
    }
}


