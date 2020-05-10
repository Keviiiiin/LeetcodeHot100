package com.iccKevin.动态规划.FindSum;

/**
 * 非递归写法
 */
public class NoRecursion {
    public Boolean Solution(int [] arr,int s){
        boolean subset[][] = new boolean[arr.length][s+1];
        for (int i = 0; i < arr.length - 1; i++) {
            subset[i][0] = true;
        }
        subset[0][arr[0]] = true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < s + 1; j++) {
                if(arr[i] > j)
                    subset[i][j] = subset[i-1][j];
                else
                    subset[i][j] = subset[i-1][j-arr[i]]||subset[i-1][j];
            }
        }
        return subset[arr.length-1][s];
    }
}
