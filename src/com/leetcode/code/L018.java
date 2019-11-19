package com.leetcode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *这个主要是解决四元组重复问题,,,就是第二个指针也要去重
 */
public class L018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length<4 || nums==null) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists=new ArrayList<>();
        Arrays.sort(nums);
        for(int a=0;a<nums.length-3;a++){

            for(int b=a+1;b<nums.length-2;b++){
                int c=b+1,d=nums.length-1;

                while(c<d){
                    int sum=nums[a]+nums[b]+nums[c]+nums[d];
                    if(sum==target){
                        lists.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]));
                        while(c<d && nums[d]==nums[d-1]) d--;
                        while(c<d && nums[c]==nums[c+1]) c++;
                        //给b去重
                        while(nums[b]==nums[b+1] && b+1<nums.length-2) b++;
                        //给a去重
                        while(nums[a]==nums[a+1] && a+1<nums.length-3) a++;
                        d--;
                        c++;
                    }else if(sum>target){
                        while(c<d && nums[d]==nums[d-1]) d--;
                        d--;
                    }else if(sum<target){
                        while(c<d && nums[c]==nums[c+1]) c++;
                        c++;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        L018 l018 = new L018();
        int[] nums={1,0,-1,0,-2,2}; //target0
        int[] nums2={-3,-2,-1,0,0,1,2,3};//target0
        int[] nums3={-1,-5,-5,-3,2,5,0,4};//target-7
        List<List<Integer>> lists = l018.fourSum(nums3, -7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
