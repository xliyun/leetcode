package com.leetcode.code;

import java.util.List;

/**
 * 这个题要注意删除倒数第链表长度个节点时
 */
public class L019 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //如果只有一个节点的情况，是应该返回空的,,这里错了好几次，，一定要好好考虑边界情况
            if(head.next==null && n==1){
                return null;
            }


            ListNode first = head;
            ListNode second = head;

            for (int i = 0; i < n; i++) {
                first = first.next;
            }

            //如果指针走到空了，就是删除倒数第链表长度个节点（就是第一个节点），那么我们直接返回第二个节点就行
            if(first==null){
                return head.next;
            }
            while (first.next != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            return head;
        }


    public static void main(String[] args) {
        L019 l019 = new L019();
        ListNode head=new ListNode(1);
        ListNode c=head;
        for(int i=2;i<=5;i++){
            c.next=new ListNode(i);
            c=c.next;
        }
        l019.print(head);

        l019.print(l019.removeNthFromEnd(head,5));
    }
    public void print(ListNode listNode){
            while(listNode!=null){
                System.out.print(listNode.val+" ");
                listNode=listNode.next;
            }
        System.out.println();
    }
}
