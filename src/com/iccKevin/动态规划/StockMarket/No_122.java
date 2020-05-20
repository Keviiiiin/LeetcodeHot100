package com.iccKevin.动态规划.StockMarket;

/**
 * @description:
 * @author: iccKevin
 * @create: 2020-05-20 22:11
 **/
public class No_122 {
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length == 0)
                return 0;
            int days = prices.length;
            int [][] dp = new int [days][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for(int i = 1;i < days;i ++){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i-1][0] - prices[i],dp[i-1][1]);
            }
            return dp[days - 1][0];
        }
    }
}