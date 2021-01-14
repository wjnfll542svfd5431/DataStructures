package com.jbit.stack;

import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.xml.transform.Source;
import java.awt.*;

/**
 * ʹ��ջ������ʽ
 */
public class Calculator {
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


            //����һ�����������Է��ص�ǰջ����ֵ, ���ǲ���������pop
            public int peek() {
                return stack[top];
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

            /**
             * �ж��Ƿ�Ϊ�����
             * @param oper
             * @return
             */
            public boolean isOper(char oper){
                return oper == '+' || oper == '-' ||  oper == '*' || oper =='/';
            }

            /**
             * ���ؽ��
             * @param num
             * @param num2
             * @param ope
             * @return
             */
            public int cal(int num,int num2,char ope){
                switch (ope){
                    case '+':
                        return num + num2;
                    case '-':
                        return num2 - num;
                    case '/':
                        return num / num2;
                    case '*':
                        return num * num2;
                    default:
                        return -1;
                }
            }

            /**
             * ���ݷ��ŷ������ȼ�
             * @param ope
             * @return
             */
            public int priority(int ope){
                if(ope == '*' || ope == '/'){
                    return 1;
                }else{
                    return 0;
                }
            }
        }

    /**
     * �������
     * @param args
     */
    public static void main(String[] args) {
        //��ջ
        ArrayStack numArrayStack = new ArrayStack(10);
        //����ջ
        ArrayStack charArrayStack = new ArrayStack(10);
        int index = 0;
        int num;
        int num1;
        //���
        int res;
        //�����
        char ope;
        char ch=' ';
        String keppNum="";
        //���ʽ
        String exp = "10*2*2-5+1-5+3-4";
        while(true){
            ch = exp.substring(index,index+1).charAt(0);
            System.out.println("��ֺ�"+ch);
            //�ж��Ƿ�Ϊ�������
            if(charArrayStack.isOper(ch)){
                if(!charArrayStack.isEmpty()){
                    if(charArrayStack.priority(ch) <= charArrayStack.priority(charArrayStack.peek())){
                        num = numArrayStack.push();
                        num1 = numArrayStack.push();
                        ope = (char) charArrayStack.push();
                        res = charArrayStack.cal(num,num1,ope);
                        //������ѹ�뵽����ջ��
                        numArrayStack.add(res);
                        //����ǰ������ѹ��ջ��
                        charArrayStack.add(ch);
                    }else{
                        charArrayStack.add(ch);
                    }
                }else{
                    charArrayStack.add(ch);
                }
            }else{
                keppNum += ch;
                if(index == exp.length()-1){
                    numArrayStack.add(Integer.parseInt(keppNum));
                }else{
                    if(numArrayStack.isOper(exp.substring(index+1,index+2).charAt(0) )){
                        numArrayStack.add(Integer.parseInt(keppNum));
                        keppNum = "";
                    }
                }
            }
            index++;
            if(index >= exp.length()){
                break;
            }
        }
        while(true){
            if(!charArrayStack.isEmpty()){
                num = numArrayStack.push();
                num1 = numArrayStack.push();
                ope = (char) charArrayStack.push();
                res = numArrayStack.cal(num,num1,ope);
                numArrayStack.add(res);
            }{
                break;
            }
        }
        System.out.println("���ʽΪ"+exp+"���Ϊ"+numArrayStack.push());
    }
}
