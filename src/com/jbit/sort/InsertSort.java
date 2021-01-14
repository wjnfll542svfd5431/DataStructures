package com.jbit.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author 王江南
 * @ClasssName 选择排序
 * @Date 2020/10/15 13:34
 * @Version 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = new int[10];
        for(int i = 0;i < array.length;i++){
            array[i] = (int)(Math.random() * 10);
        }
        Date before = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(before);
        InsertSort.insertSort(array);
    }

    /**
     * 选择排序
     * @param array
     */
    public static void insertSort(int []array){
        int value = 0;
        int  index= 0;
        for(int i = 1;i < array.length;i++){
            value = array[i];
            index = i -1;

            while(index >= 0 && value < array[index]){
                array[index + 1] = array[index];
                index--;
            }
            array[index+1]=value;
            System.out.println(Arrays.toString(array));
        }
    }
}
