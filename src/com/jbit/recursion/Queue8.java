package com.jbit.recursion;

/**
 * @Author 王江南
 * @ClasssName Queue8
 * @Date 2020/10/8 20:41
 * @Version 1.0
 */
public class Queue8 {
    //下标代表里列，value代表行
    int max = 8;
    int[] array = new int[max];
    int cont = 0;
    public static void main(String[] args) {
        Queue8 qu = new Queue8();
        qu.check(0);
        System.out.println("方法有"+qu.cont+"种");
    }

    public void check(int n){
        if(n == max){
            printh();
            return;
        }
        for(int i = 0; i < max; i++){
            array[n] = i;
            //不重复重新递归
            if(juede(n)){
                check(n + 1);
            }
        }
    }

    /**
     * 判断皇后位置是否冲突
     * @param n
     * @return
     */
    public  boolean juede(int n){
       for(int i = 0;i < n;i++){
           //先判断是否在同列上
           //后判断是否在斜线上,math.abs()去正整数
           if(array[i] == array[n] || Math.abs(i - n) == Math.abs(array[i] - array[n])){
                return false;
           }
       }
        return true;
    }

    /**
     * 打印
     *
     */
    public  void printh(){
        cont++;
        for(int i = 0; i <array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println(" ");
    }
}

