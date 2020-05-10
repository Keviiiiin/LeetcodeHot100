package com.iccKevin.动态规划.不相邻的最大和;

/*
    给出一个数组，返回不相邻数的最大和
    如 4,2,1,9,1 最大为13
 */
public class Recursion {
    // 到第i个位置的最大和
    public Integer bestOption(int[] arr,int i){
        // 出口
        if(i==0)    return arr[0];
        if(i==1)    return Math.max(arr[0],arr[1]);
        // 选第i个or不选第i个
        return Math.max(bestOption(arr,i-2)+arr[i] , bestOption(arr,i-1));
    }
}
