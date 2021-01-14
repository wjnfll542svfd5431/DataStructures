package com.jbit.test;

public class Test {
    public static void main(String[] args) {
        System.out.println(fu());
    }
    public static int fu(){
        int a=80;
        try {
            System.out.println(a/0);
        }catch (Exception e){
            System.out.println("ssss");
            a=1;
            return a;
        }finally {
            System.out.println("f");
        }
        return a=2;
    }
}
