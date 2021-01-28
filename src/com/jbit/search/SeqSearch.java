package com.jbit.search;

/**
 * @Author 王江南
 * @ClasssName 线性查找
 * @Date 2021/1/15 14:37
 * @Version 1.0
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {-1, 8, 1, 6, 5, 9, 10, 6};
        int index = seqSearch(arr,10);
        if(index == -1){
            System.out.println("没找到："+index);
        }else{
            System.out.println("下标为："+index);
        }


    }

    public static int seqSearch(int[] arr, int nub) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == nub) {
                return i;
            }
        }
        return -1;
    }
}
