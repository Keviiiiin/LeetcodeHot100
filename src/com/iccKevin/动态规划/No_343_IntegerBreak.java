package com.iccKevin.动态规划;

/**
 * @description:
 * @author: iccKevin
 * @create: 2020-05-21 16:54
 **/
public class No_343_IntegerBreak {
    public int integerBreak(int n) {
        if(n == 1 || n == 2)
            return 1;
        int []dp = new int [n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3 ; i <= n ; i++){
            for(int j = 1 ; j <= i / 2 ; j++){
                dp[i] = Math.max(dp[i],Math.max(j * (i - j),Math.max(j * dp[i - j],Math.max(dp[j] * (i - j),dp[j] * dp[i - j]))));
            }
        }
        return dp[n];
    }
}