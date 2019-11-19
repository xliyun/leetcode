package com.leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: xiaoliyu
 * @date: 2019-11-15 14:35
 */
public class L022 {
    private List<String> list=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n==0){
            return new ArrayList<>();
        }

        buildStr("",n,n);
        return list;
    }

    public void buildStr(String str,int lb,int rb){
        //左括号和右括号都用上了的时候，就是结果了
        if(lb==0 && rb==0){
            list.add(str);
        }
        //如果左括号剩的少，左括号和右括号都能放
        if(lb<rb){
            //如果左括号还有
            if(lb>=0){
                buildStr(str+"(",lb-1,rb);
            }
            if(rb>=0) {
                buildStr(str + ")", lb, rb - 1);
            }

        }else{//这种情况应该是左右括号一样多的时候，只能放左括号
            buildStr(str+"(",lb-1,rb);
        }

    }

    public static void main(String[] args) {
        L022 l022 = new L022();
        List<String> list=l022.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
