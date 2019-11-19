package com.leetcode.code;

/**
 * @description:链表相关工具
 * @author: xiaoliyu
 * @date: 2019-11-15 13:57
 */
public class ListNodeUtils {
    public static void printLink(ListNode head){
        if(head==null){
            System.out.println("==链表为空==");
        }else {
            while (head != null){
                System.out.print(head.val+" ");
                head=head.next;
            }
            System.out.println();
        }
    }
    public static ListNode buildLink(int n){
        if(n<=0){
            System.out.println("==输入大于0==");
        }
        ListNode head = new ListNode(1);
        ListNode ch=head;
        for(int i=1;i<n;i++){
            ch.next=new ListNode(i+1);
            ch=ch.next;
        }
        return head;
    }

    public static ListNode buildLink(int[] n){
        if(n.length<=0){
            System.out.println("==输入大于0==");
        }
        ListNode head = new ListNode(n[0]);
        ListNode ch=head;
        for(int i=1;i<n.length;i++){
            ch.next=new ListNode(n[i]);
            ch=ch.next;
        }
        return head;
    }
}
