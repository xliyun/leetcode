package com.leetcode.code;

/**
 * @description:
 * @author: xiaoliyu
 * @date: 2019-11-19 10:02
 */
public class L027 {
    public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0)
            return 0;

        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i++]=nums[j];
            }
        }
        return i;
    }
}
