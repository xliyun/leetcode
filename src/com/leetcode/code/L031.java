package com.leetcode.code;

/**
 * 这个题的题意不好理解，就是1234三个数组成的数字，找出刚好比123大的数，就是1243
 * 解题思路就是倒着找
 */
public class L031 {
    public void nextPermutation(int[] nums) {

        if(nums==null || nums.length==0 || nums.length==1)
            return;

        int a=nums.length-1;

        //找出从尾部开始结束升序的数字位置
        while(a>0){
            if(nums[a]>nums[a-1]){
                break;
            }

            a=a-1;
        }

        int b=a-1;

        if(b>=0) {
            for (int c = nums.length - 1; c > b; c--) {
                if (nums[b] < nums[c]) {
                    change(nums, b, c);
                    break;
                }
            }

            revese(nums, b + 1);
        }else {
            revese(nums,0);
        }
    }

    private void revese(int[] nums, int i) {
        int len=(nums.length-i)/2;
        int length=nums.length-1;
        for(int j=0;j<len;j++){
            int ch=nums[i+j];
            nums[i+j]=nums[length-j];
            nums[length-j]=ch;
        }

    }

    public void change(int[] nums,int a,int b){
        int ch=nums[a];
        nums[a]=nums[b];
        nums[b]=ch;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        int[] nums2={1,1};//边界数据
        int[] nums3={1,2};
        int[] nums4={1,3,2};
        int[] nums5={3,2,1};
        L031 l031 = new L031();
        l031.nextPermutation(nums5);

        for (int num : nums5) {
            System.out.print(num+" ");
        }
    }
}
