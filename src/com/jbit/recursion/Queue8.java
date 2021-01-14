package com.jbit.recursion;

/**
 * @Author ������
 * @ClasssName Queue8
 * @Date 2020/10/8 20:41
 * @Version 1.0
 */
public class Queue8 {
    //�±�������У�value������
    int max = 8;
    int[] array = new int[max];
    int cont = 0;
    public static void main(String[] args) {
        Queue8 qu = new Queue8();
        qu.check(0);
        System.out.println("������"+qu.cont+"��");
    }

    public void check(int n){
        if(n == max){
            printh();
            return;
        }
        for(int i = 0; i < max; i++){
            array[n] = i;
            //���ظ����µݹ�
            if(juede(n)){
                check(n + 1);
            }
        }
    }

    /**
     * �жϻʺ�λ���Ƿ��ͻ
     * @param n
     * @return
     */
    public  boolean juede(int n){
       for(int i = 0;i < n;i++){
           //���ж��Ƿ���ͬ����
           //���ж��Ƿ���б����,math.abs()ȥ������
           if(array[i] == array[n] || Math.abs(i - n) == Math.abs(array[i] - array[n])){
                return false;
           }
       }
        return true;
    }

    /**
     * ��ӡ
     *
     */
    public  void printh(){
        cont++;
        for(int i = 0; i <array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println(" ");
    }
}

