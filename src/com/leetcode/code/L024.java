package com.leetcode.code;

import java.util.LinkedList;

/**
 * @description:
 * @author: xiaoliyu
 * @date: 2019-11-15 16:04
 */
public class L024 {
   /* public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        LinkedList<ListNode> queue=new LinkedList<>();

        ListNode first=head;
        ListNode secod=head;

        //交换第一组，把头记录下来
        *//*
        * a=第一个节点
        * b=第二个节点
        * ch=b.next（第三个节点）
        * b.next=a
        * a.next=ch
        * ------下一个循环
        * a=ch
        * b=ch.next
        * ch=b.next
        *//*
        first=first.next;
        secod.next=first.next;//指向第三个节点
        head=first;
        first.next=secod;


        while(first!=null){

            for(int i=0;i<1;i++){
                first=first.next;
                secod=
            }
        }

        return head;
    }*/

    //public LinkedList<ListNode>

    public static void main(String[] args) {

    }
}
