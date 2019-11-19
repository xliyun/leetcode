package com.leetcode.code;

/**
 * @description:
 * @author: xiaoliyu
 * @date: 2019-11-19 9:43
 */
public class L026 {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int i=0;

        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                nums[++i]=nums[j];
            }
        }

        return i+1;
    }
}
