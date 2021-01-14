package com.jbit.sort;

import java.util.Arrays;

/**
 * @Author ������
 * ��������
 * @ClasssName QuickSort
 * @Date 2020/12/31 16:15
 * @Version 1.0
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arry = new int[]{1,6,5,8,9,2,5,15,-5,3,53};
       // QuickSort.quickSort(arry,0,arry.length-1);
    }


    /**
     * ����
     * @param arry
     * @param left
     * @param right
     */
    public static void  quickSort(int[] arry,int left,int right){
        int l = left;
        int r = right;
        int prvot = arry[(left+right) /2];
        int temp = 0;
        while(l < r){
            while(arry[l] < prvot){
                l += 1;
            }
            while(arry[r] > prvot){
                r -= 1;
            }
            if(l == r){
                break;
            }
            temp = arry[l];
            arry[l] = arry[r];
            arry[r] = temp;


            if(arry[l] == prvot){
                r -= 1;
            }
            if(arry[r] == prvot){
                l += 1;
            }
            // ��� l == r, ����l++, r--, ����Ϊ����ջ���
            if (l == r) {
                l += 1;
                r -= 1;
            }
            //����ݹ�
            if(left < r) {
                quickSort(arry, left, r);
            }
            //���ҵݹ�
            if(right > l) {
                quickSort(arry, l, right);
            }
        }
        System.out.println("array: "+ Arrays.toString(arry));

    }
}
