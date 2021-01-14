package com.jbit.atguigui;

import java.util.Scanner;

/**
 * 数组模拟队列
 */
public class queue {
    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner input = new Scanner(System.in);
        int key =0;
        boolean bool = true;
        while(bool){
            System.out.println("1: 显示队列");
            System.out.println("2: 退出程序");
            System.out.println("3: 添加数据到队列中");
            System.out.println("4: 从队列中拿取数据");
            System.out.println("5: 查看队列列头数据");
            key =input.nextInt();
            switch (key){
                case 1:
                    arrayQueue.showQueue();
                    break;
                case 2:
                    bool = false;
                    input.close();
                    break;
                case 3:
                    System.out.println("请输入一个数");
                    int value = input.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 4:
                    try {
                        int res=arrayQueue.getQueue();
                        System.out.println("拿出数据为"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        int res=arrayQueue.getFront();
                        System.out.println("列头为"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");


    }

    static class ArrayQueue{
        //最大容量
        private int maxSize;
        //表头部
        private int front;
        //表尾部
        private int rear;
        //数组
        private int[] array;

        /**
         * 构造函数，初始化变量
         * @param maxSize
         */
        public ArrayQueue(int maxSize){
            this.maxSize = maxSize;
            this.front = -1;
            this.rear = -1;
            this.array = new int[this.maxSize];
        }

        /**
         * 判断是否为空，当尾部等于头部时为空
         * @return
         */
        public boolean isEmpty(){
            return rear == front;
        }

        /**
         * 判断队列是否满
         * @return
         */
        public boolean isFull(){
            return rear == maxSize-1;
        }

        /**
         * 向队列中添加数据
         * @param n
         */
        public void addQueue(int n){
            if(isFull()){
                System.out.println("队列以满");
                return;
            }
            rear++;
            array[rear] = n;
        }

        /**
         * 取出队列数据
         * @return
         */
        public int getQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列为空");
            }
            front++;
            return array[front];
        }

        /**
         * 查看队列所有数据
         */
        public void showQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列为空");
            }
            for (int i = 0;i < array.length;i++){
                System.out.printf("arr[%d]=%d/n",i,array[i]);
            }
        }

        public int getFront(){
            if(isEmpty()){
                throw new RuntimeException("队列为空");
            }
            return array[front+1];
        }
    }
}
