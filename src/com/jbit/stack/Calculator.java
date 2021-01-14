package com.jbit.stack;

import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.xml.transform.Source;
import java.awt.*;

/**
 * 使用栈计算表达式
 */
public class Calculator {
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


            //增加一个方法，可以返回当前栈顶的值, 但是不是真正的pop
            public int peek() {
                return stack[top];
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

            /**
             * 判断是否为运算符
             * @param oper
             * @return
             */
            public boolean isOper(char oper){
                return oper == '+' || oper == '-' ||  oper == '*' || oper =='/';
            }

            /**
             * 返回结果
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
             * 根据符号返回优先级
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
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        //数栈
        ArrayStack numArrayStack = new ArrayStack(10);
        //符号栈
        ArrayStack charArrayStack = new ArrayStack(10);
        int index = 0;
        int num;
        int num1;
        //结果
        int res;
        //运算符
        char ope;
        char ch=' ';
        String keppNum="";
        //表达式
        String exp = "10*2*2-5+1-5+3-4";
        while(true){
            ch = exp.substring(index,index+1).charAt(0);
            System.out.println("拆分后"+ch);
            //判断是否为运算符号
            if(charArrayStack.isOper(ch)){
                if(!charArrayStack.isEmpty()){
                    if(charArrayStack.priority(ch) <= charArrayStack.priority(charArrayStack.peek())){
                        num = numArrayStack.push();
                        num1 = numArrayStack.push();
                        ope = (char) charArrayStack.push();
                        res = charArrayStack.cal(num,num1,ope);
                        //计算结果压入到数据栈中
                        numArrayStack.add(res);
                        //将当前操作符压入栈中
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
        System.out.println("表达式为"+exp+"结果为"+numArrayStack.push());
    }
}
