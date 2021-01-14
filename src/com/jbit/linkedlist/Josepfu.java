package com.jbit.linkedlist;

/**
 * ��������
 */
public class Josepfu {
    public static void main(String[] args) {
        util.add(5);
        util.showBody();
        util.countBoy(1,2,5);
    }

    static class util{
        private static Body fast = null;
        /**
         * �������ʹ����ʵ�ֻ���
         * @param number
         */
        public static void add(int number){
            //���������ڵ�����г̻���
            Body temp = null;
            for (int i = 1;i <= number;i++){
                Body body = new Body(i);
                //��һ�������γɻ�״
                if(i == 1){
                    fast = body;
                    fast.setNext(fast);
                    temp = fast;
                }else{
                    //�����ƶ�һλ
                    temp.setNext(body);
                    //nextָ���һ���γɻ�״
                    body.setNext(fast);
                    temp = body;
                }
            }
        }
        public static void showBody(){
            if(fast == null){
                System.out.println("����Ϊ��");
            }
            Body temp = fast;
            while(true){
                System.out.println("���Ϊ"+temp);
                if(temp.getNext() == fast){
                    break;
                }
                //����ƶ�һλ
                temp = temp.getNext();
            }
        }

        /**
         *
         * @param startNo �ӵڼ�����ʼ��
         * @param countNum ������
         * @param nums
         */
        public static void countBoy(int startNo, int countNum, int nums){
            Body temp = fast;
           while(true){
               if(temp.getNext() == fast){
                   break;
               }
               temp = temp.getNext();
           }
            for (int i=0;i<startNo-1;i++){
                temp = temp.getNext();
                fast = fast.getNext();
            }

            while(true){
                if(temp == fast){
                    break;
                }
                for (int i=0;i<countNum-1;i++){
                    temp = temp.getNext();
                    fast = fast.next;
                }
                System.out.println("��Ȧ��С��"+fast.getNo());
                fast = fast.getNext();
                temp.setNext(fast);
            }
            System.out.println("��Ȧ�е�С��"+fast.getNo());
        }
    }


    /**
     * ����ʵ��
     */
    static class Body{
        //���
        public int no;
        //next��
        public Body next;

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public Body getNext() {
            return next;
        }

        public void setNext(Body next) {
            this.next = next;
        }

        public Body(int no){
            this.no = no;
        }

        @Override
        public String toString() {
            return "Body{" +
                    "no=" + no +
                    '}';
        }
    }
}
