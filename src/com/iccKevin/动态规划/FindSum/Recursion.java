package com.iccKevin.动态规划.FindSum;

// 给出一个数组和一个整数，判断是否能用数组中的若干个数组成该整数
public class Recursion {
    // 到第i个位置能否拼出s
    public Boolean Solution(int [] arr,int i,int s) {
        if(s==0)    return true;
        if(i==0)    return arr[0]==s;
        // 当前数大于和，只能不选
        if(arr[i]>s)    return Solution(arr,i-1,s);
        // 选i||不选i
        return Solution(arr,i-1,s-arr[i])||Solution(arr,i-1,s);
    }

    public static void main(String[] args) {
        int [] arr={3,34,4,12,5,2};
        System.out.println(new Recursion().Solution(arr,arr.length-1,9));
        System.out.println(new Recursion().Solution(arr,arr.length-1,10));
        System.out.println(new Recursion().Solution(arr,arr.length-1,11));
        System.out.println(new Recursion().Solution(arr,arr.length-1,12));
        System.out.println(new Recursion().Solution(arr,arr.length-1,13));

        System.out.println(new NoRecursion().Solution(arr,9));
        System.out.println(new NoRecursion().Solution(arr,10));
        System.out.println(new NoRecursion().Solution(arr,11));
        System.out.println(new NoRecursion().Solution(arr,12));
        System.out.println(new NoRecursion().Solution(arr,13));
    }
}
