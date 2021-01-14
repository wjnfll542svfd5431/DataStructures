package com.jbit.stack;

import java.util.Scanner;

public class ArrayStackDemo {

    static  class ArrayStack{
        //ջ��󳤶�
        private int maxSize;

        private int[] stack;
        //ջ��
        private int top = -1;

        public ArrayStack(int maxSize){
            this.maxSize = maxSize;
            stack = new int[maxSize];
        }

        /**
         * ջ�Ƿ�Ϊ��
         * @return
         */
        public boolean isEmpty(){
            return top == -1;
        }

        /**
         * ջ��
         * @return
         */
        public boolean isFull(){
            return top == maxSize-1;
        }

        /**
         * ���
         * @param num
         */
        public void add(int num){
            if(isFull()){
                System.out.println("ջ�����������");
            }
            top++;
            stack[top] = num;

        }

        /**
         *��ջ����ȡ����
         * @return
         */
        public int push(){
            if(isEmpty()){
                throw new RuntimeException("�쳣֪ͨ");
            }
            int value = stack[top];
            top--;
            return value;
        }

        /**
         * ��ʾջ������
         */
        public void showStack(){
            for (int i = 0;i < stack.length;i++){
                System.out.println("ջ������Ϊ"+stack[i]);
            }
        }
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        boolean log = true;
        int i;
        Scanner input = new Scanner(System.in);

        while(log){
            System.out.println("1����ʾջ������");
            System.out.println("2: �������");
            System.out.println("3: ������");
            System.out.println("4�� �˳�");
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
