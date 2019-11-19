package com.leetcode.code;

/**
 * 这个题要注意匹配不成功后，i不能从当前位置向下走，应该回到最初匹配的位置
 */
public class L028 {
    public int strStr(String haystack, String needle) {
        if(needle==null || needle.length()==0)
            return 0;

        if(haystack==null || haystack.length()==0)
            return -1;

        int index=0;
        int ch=0;
        for(int i=0;i<haystack.length();){
            if(haystack.charAt(i)==needle.charAt(ch)){
                if(ch==needle.length()-1){
                    return i-ch;
                }
                ch++;
                i++;
            }else {
                if(ch>0) {
                    i = i - ch+1;
                }else{
                    i++;
                }
                ch=0;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        L028 l028 = new L028();

        System.out.println(l028.strStr("mississippi","issip"));
        //i==5  ch==4
    }
}
