package com.jbit.linkedlist;

import java.net.HttpRetryException;
import java.util.HashMap;
import java.util.Map;

/**
 * 单链表
 */
public class LinkendListDemo {
    public static void main(String[] args) {
        HeroNode heroNode = new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode2 = new HeroNode(2,"林冲","豹子头");
        HeroNode heroNode3 = new HeroNode(3,"卢俊义","玉麒麟");
        HeroNode heroNode4 = new HeroNode(4,"吴用","智多星");
        LinkdendListUtil  linkdendListUtil= new LinkdendListUtil();
        linkdendListUtil.addByOrder(heroNode);
        linkdendListUtil.addByOrder(heroNode3);
        linkdendListUtil.addByOrder(heroNode4);
        linkdendListUtil.addByOrder(heroNode2);
        System.out.println("链表反转前");
        linkdendListUtil.traverse();
        System.out.println("链表反转后");
        linkdendListUtil.reversetList(LinkdendListUtil.getHerd());
        linkdendListUtil.traverse();
       /* System.out.println("修改后");
        HeroNode heroNode5 = new HeroNode(2,"林冲","豹子头~~~");
        linkdendListUtil.update(heroNode5);
        linkdendListUtil.traverse();
        System.out.println(linkdendListUtil.count());
        System.out.println("删除前");
        linkdendListUtil.traverse();
        System.out.println("删除后");
        linkdendListUtil.del(1);
        linkdendListUtil.traverse();
        System.out.println(linkdendListUtil.count());
        System.out.println(linkdendListUtil.lastNode(1, LinkdendListUtil.getHerd()));*/
    }

    /**
     * 英雄管理
     */
    static class LinkdendListUtil{
        //头结点
        private  static HeroNode herd= new HeroNode(0,"","");

        public static HeroNode getHerd(){
            return herd;
        }
        /**
         * 向链表尾部进行添加英雄
         * @param heroNode
         */
        public void add(HeroNode heroNode){
            HeroNode temp = herd;
            while(true){
                if(temp.next == null){
                    break;
                }
                //如果没有找到就往后移动一位
                temp = temp.next;
            }

            temp.next = heroNode;
        }

        /**
         * 向链表中有序的添加英雄
         * @param heroNode
         */
        public void addByOrder(HeroNode heroNode){
            //需要借助辅助变量来指定链表头部
            HeroNode temp = herd;
            //判断要插入英雄编号是否已经重复
            boolean fag = false;
            while(true){
                //判断链表是否为最后一位
                if(temp.next == null){
                    break;
                }else if(temp.next.no > heroNode.no){
                    break;
                }else if(temp.next.no == heroNode.no){
                    fag = true;
                    break;
                }
                temp = temp.next;
            }
            if(fag){
                System.out.println("要插入的英雄已经存在");
            }else{
                heroNode.next = temp.next;
                temp.next = heroNode;
            }
        }

        /**
         * 修改链表中对象
         * @param heroNode
         */
        public void update(HeroNode heroNode){
            if(herd.next == null){
                System.out.println("链表中没有数据");
                return;
            }
            HeroNode temp = herd.next;
            boolean flag = false;
            while(true){
                //判断是否为最后一位
                if(temp == null){
                    break;
                }else if(temp.no == heroNode.no){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if(flag){
                temp.nickName = heroNode.nickName;
                temp.name = heroNode.name;
            }
        }

        /**
         * 删除单链表中的数据
         * @param no
         */
        public void del(int no){
            HeroNode temp = herd;
            boolean flag = false;
            while(true){
                if(temp.next == null){
                    break;
                }else if(temp.next.no == no){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if(flag){
                temp.next = temp.next.next;
            }else{
                System.out.println("要删除编号不存在");
            }
        }

        /**
         * 查询链表中有效的元素
         */
        public int count(){
            HeroNode temp = herd.next;
            int sum = 0;
            while(temp != null){
                sum++;
                temp = temp.next;
            }
            return sum;
        }

        /**
         * 将链表反转
         * @param herd
         */
        public  void reversetList(HeroNode herd){

            //如果链表中只有一位或者为空直接退出
            if(herd.next == null || herd.next.next == null){
              return;
            }
            System.out.println(herd.next);
            //辅助变量帮助遍历
            HeroNode nodel = herd.next;
            //保存node.next节点
            HeroNode next = null;
            HeroNode reverHeroNode = new HeroNode(0,"","");
            while(nodel != null){
                next = nodel.next;
                nodel.next = reverHeroNode.next;
                reverHeroNode.next = nodel;
                nodel = next;
            }
            herd.next=reverHeroNode.next;
        }

        /**
         * 查询链表中
         * @param number
         * @return
         */
        public HeroNode lastNode(int number,HeroNode heroNode){
            if(heroNode.next == null){
                return null;
            }
            HeroNode temp = heroNode.next;
            int size =count();
            System.out.println(size);
            for (int i=0;i<size-number;i++){
                temp = temp.next;
            }
            return temp;
        }
        /**
         * 遍历单链表
         */
        public void traverse(){
           if(herd.next == null){
               System.out.println("链表为空");
               return;
           }
           //头链表后一位
           HeroNode temp = herd.next;
           while(true){
               if(temp != null){
                   System.out.println(temp);
                   //指向链表后一位
                   temp = temp.next;
               }else{
                   break;
               }
           }
        }

    }



    /**
     * hero对象，每一个hero就是一个节点
     */
    static class HeroNode{
        public int no;
        public String name;
        public String nickName;
        //指向下一个节点
        public HeroNode next;

        public HeroNode(int no,String name,String nickName){
            this.no = no;
            this.nickName = nickName;
            this.name = name;
        }


        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }
}
