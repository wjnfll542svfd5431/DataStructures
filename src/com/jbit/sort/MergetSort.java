package com.jbit.sort;

import java.util.Arrays;

/**
 * @Author 王江南
 * @ClasssName 归并排序
 * @Date 2021/1/11 22:06
 * @Version 1.0
 */
public class MergetSort {
    public static void main(String[] args) {
        int[] arry = {5,1,7,3,2,2,9,10};
        int [] tempArr = new int[arry.length];
        merget(arry,0,arry.length - 1,tempArr);
    }


    /**
     * 归并
     * @param arr
     * @param left
     * @param right
     */
    public static void merget(int[] arr,int left,int right,int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            merget(arr,left,mid,temp);
            merget(arr,mid+1,right,temp);
            sort(arr,left,right,temp,mid);
        }
    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     * @param mid
     */
    public static void sort(int[] arr,int left,int right,int[] temp,int mid){
        int i = left;
        int j = mid + 1;
        int t = 0;
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }else{
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        while(i <=mid){
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while(j <= right){
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        t = 0;
        int tempLeft = left;
        while(tempLeft <= right){
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

        System.out.println(Arrays.toString(arr));

    }


}
