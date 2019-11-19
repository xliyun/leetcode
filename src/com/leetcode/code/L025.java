package com.leetcode.code;

import java.util.List;

/**
 * @description:
 * @author: xiaoliyu
 * @date: 2019-11-19 9:13
 */
public class L025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;

        ListNode aaa=dummy;
        ListNode bbb=dummy;

        while(bbb.next!=null){
            for(int i=0;i<k && bbb!=null;i++) bbb=bbb.next;
            if(bbb==null) break;

            ListNode aaa2=aaa.next;
            ListNode bbb2=bbb.next;

            bbb.next=null;//先行的指针和后面断开

            aaa.next=reverseLink(aaa2);
            aaa2.next=bbb2;
            aaa=aaa2;

            bbb=aaa;

        }

        return dummy.next;
    }
    public ListNode reverseLink(ListNode head){

        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;

    }
}
