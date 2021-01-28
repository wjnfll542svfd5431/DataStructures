package com.jbit.search;

/**
 * @Author 王江南
 * @ClasssName (必须是有序的)二分查找
 * @Date 2021/1/15 15:22
 * @Version 1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,6,9,10,50,69,72,85};
        System.out.println(BinarySearch(0,arr.length-1,99,arr));
    }
    public static int BinarySearch(int left,int right,int nub,int[] arr){
        if(left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        if(nub > arr[mid]){
            return BinarySearch(mid + 1,right,nub,arr);
        }else if(nub < arr[mid]){
            return BinarySearch(left,mid - 1,nub,arr);
        }else{
            return mid;
        }
    }

}
