package com.leetcode.code;

/**
 * @description:
 * @author: xiaoliyu
 * @date: 2019-11-15 13:47
 */
public class L021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            return null;
        }else if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }


        ListNode head;

        ListNode l1_pointer=l1;
        ListNode l2_pointer=l2;

        //获取头
        if(l1_pointer.val<l2_pointer.val){
            head=l1_pointer;
            l1_pointer=l1_pointer.next;
        }else{
            head=l2_pointer;
            l2_pointer=l2_pointer.next;
        }

        ListNode ch=head;
        while(l1_pointer!=null && l2_pointer!=null){
            if(l1_pointer.val<l2_pointer.val){
                ch.next=l1_pointer;
                ch=ch.next;
                l1_pointer=l1_pointer.next;
            }else{
                ch.next=l2_pointer;
                ch=ch.next;
                l2_pointer=l2_pointer.next;
            }
        }

        if(l1_pointer==null){
            ch.next=l2_pointer;
        }else{
            ch.next=l1_pointer;
        }

        return head;
    }

    public static void main(String[] args) {

        L021 l021 = new L021();
        int[] num1={1,2,4};
        int[] num2={1,3,4};
        ListNode l1=ListNodeUtils.buildLink(num1);
        ListNodeUtils.printLink(l1);
        ListNode l2=ListNodeUtils.buildLink(num2);
        ListNodeUtils.printLink(l2);

        ListNode head=l021.mergeTwoLists(l1,l2);

        ListNodeUtils.printLink(head);
    }
}
