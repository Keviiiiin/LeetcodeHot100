package com.iccKevin.动态规划.不相邻的最大和;

import com.iccKevin.字符串.No_5_Palindromic.Manacher_On;

/**
 *  非递归写法
 */
public class NoRecursion {
    private static int[] res = {1,2,4,1,7,8,3};
    public Integer Solution(int[] arr){
        int [] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0],arr[1]);
        for (int j = 2; j <arr.length ; j++) {
            opt[j] = Math.max(opt[j-2]+arr[j],opt[j-1]);
        }
        return opt[arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new NoRecursion().Solution(res));
    }
}
