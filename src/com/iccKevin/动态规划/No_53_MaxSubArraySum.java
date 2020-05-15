package com.iccKevin.动态规划;

/**
 * @description:
 * @author: iccKevin
 * @create: 2020-05-15 19:31
 **/
public class No_53_MaxSubArraySum {
    public int maxSubArray(int[] nums) {
        // if(nums.size() == 0 )   return 0;
        if(nums.length == 1 )   return nums[0];
        // return Math.max(maxSubArray(nums(0,i-1))+i,nums(0,i-1)));
        int[] maxSum = new int [nums.length];
        maxSum[0] = nums[0];
        int max = nums[0];
        for(int i = 1;i < nums.length; i ++){
            if(maxSum[i - 1] >= 0)
                maxSum[i] = maxSum[i - 1] + nums[i];
            else
                maxSum[i] = nums[i];
            max = Math.max(max,maxSum[i]);
        }
        return max;
    }
}