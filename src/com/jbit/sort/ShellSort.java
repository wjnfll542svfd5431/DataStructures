package com.jbit.sort;


import java.util.Arrays;

/**
 * @Author Íõ½­ÄÏ
 * @ClasssName Ï£¶ûÅÅĞò
 * @Date 2020/11/24 10:12
 * @Version 1.0
 */
public class ShellSort {
   static int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };

    public static void main(String[] args) {
        shellsort(arr);
    }



    public static void shellsort(int[] array){
        for(int gap = array.length / 2;gap > 0;gap /= 2){
            for (int i =gap; i< array.length;i++){
                for(int j = i - gap;j >= 0; j -= gap){
                    if(array[j] > array[j + gap]){
                        int temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
