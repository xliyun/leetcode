package com.leetcode.code;

/**
 * @description:
 * @author: xiaoliyu
 * @date: 2019-11-15 15:14
 */
public class L023 {
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

    public ListNode mergeKLists(ListNode[] lists) {
        int length=lists.length;
        if(lists==null || lists.length==0){
            return null;
        }

      //  int x=length;

        while(length>1){
            int x=length/2;

            for(int i=0;i<x;i++){
                lists[i]=mergeTwoLists(lists[i],lists[length-1-i]);
            }
            length=length/2+length%2;
        }
        return lists[0];
    }

    public static void main(String[] args) {
        L023 l023 = new L023();

    }
}
