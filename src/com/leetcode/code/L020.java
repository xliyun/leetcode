package com.leetcode.code;

import java.util.LinkedList;

/**
 * 正好用来练习LinkedList
 */
public class L020 {
    public boolean isValid(String s) {
        if(s==null || s==""){
            return false;
        }

        LinkedList<String> queue=new LinkedList();
        for(int i=0;i<s.length();i++){

            if(queue.isEmpty()){
                queue.addLast(s.substring(i,i+1));
            }
            else {
                String eh=queue.getLast();
                if ((eh.equals("(") && s.substring(i, i + 1).equals(")"))
                        || (eh.equals("{") && s.substring(i, i + 1).equals("}"))
                        || (eh.equals("[") && s.substring(i, i + 1).equals("]"))
                ) {
                    queue.removeLast();
                } else {
                    queue.addLast(s.substring(i, i + 1));
                }
            }
        }

        if(queue.isEmpty())
            return true;

        return false;
    }

    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<>();
        L020 l020 = new L020();
        String str="()";
        System.out.println(l020.isValid(str));
        System.out.println(list.isEmpty());
    }
}
