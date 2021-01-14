package com.jbit.stack;

import java.util.Scanner;

public class ArrayStackDemo {

    static  class ArrayStack{
        //栈最大长度
        private int maxSize;

        private int[] stack;
        //栈顶
        private int top = -1;

        public ArrayStack(int maxSize){
            this.maxSize = maxSize;
            stack = new int[maxSize];
        }

        /**
         * 栈是否为空
         * @return
         */
        public boolean isEmpty(){
            return top == -1;
        }

        /**
         * 栈满
         * @return
         */
        public boolean isFull(){
            return top == maxSize-1;
        }

        /**
         * 添加
         * @param num
         */
        public void add(int num){
            if(isFull()){
                System.out.println("栈满，不可添加");
            }
            top++;
            stack[top] = num;

        }

        /**
         *从栈顶拿取数据
         * @return
         */
        public int push(){
            if(isEmpty()){
                throw new RuntimeException("异常通知");
            }
            int value = stack[top];
            top--;
            return value;
        }

        /**
         * 显示栈中数据
         */
        public void showStack(){
            for (int i = 0;i < stack.length;i++){
                System.out.println("栈中数据为"+stack[i]);
            }
        }
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        boolean log = true;
        int i;
        Scanner input = new Scanner(System.in);

        while(log){
            System.out.println("1：显示栈中数据");
            System.out.println("2: 添加数据");
            System.out.println("3: 拿数据");
            System.out.println("4： 退出");
            i = input.nextInt();
            switch(i){
                case 1:
                    arrayStack.showStack();
                    break;
                case 2:
                    int num = input.nextInt();
                    arrayStack.add(num);
                    break;
                case 3:
                    try {
                        System.out.println(arrayStack.push());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }
    }
}
