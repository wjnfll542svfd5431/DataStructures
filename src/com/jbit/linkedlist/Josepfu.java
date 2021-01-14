package com.jbit.linkedlist;

/**
 * 环行链表
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
         * 添加数，使链表实现环行
         * @param number
         */
        public static void add(int number){
            //创建辅助节点帮助行程环行
            Body temp = null;
            for (int i = 1;i <= number;i++){
                Body body = new Body(i);
                //第一个自我形成环状
                if(i == 1){
                    fast = body;
                    fast.setNext(fast);
                    temp = fast;
                }else{
                    //往后移动一位
                    temp.setNext(body);
                    //next指向第一个形成环状
                    body.setNext(fast);
                    temp = body;
                }
            }
        }
        public static void showBody(){
            if(fast == null){
                System.out.println("链表为空");
            }
            Body temp = fast;
            while(true){
                System.out.println("编号为"+temp);
                if(temp.getNext() == fast){
                    break;
                }
                //向后移动一位
                temp = temp.getNext();
            }
        }

        /**
         *
         * @param startNo 从第几个开始数
         * @param countNum 数几次
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
                System.out.println("出圈的小孩"+fast.getNo());
                fast = fast.getNext();
                temp.setNext(fast);
            }
            System.out.println("在圈中的小孩"+fast.getNo());
        }
    }


    /**
     * 链表实体
     */
    static class Body{
        //编号
        public int no;
        //next域
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
