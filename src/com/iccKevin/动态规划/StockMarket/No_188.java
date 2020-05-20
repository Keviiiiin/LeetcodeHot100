package com.iccKevin.动态规划.StockMarket;

/**
 * @description:
 * @author: iccKevin
 * @create: 2020-05-20 22:55
 **/
public class No_188 {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if(prices == null || prices.length == 0)
                return 0;
            int days = prices.length;
            // 天数；是否持股；还剩几次交易
            if(k > days/2){
                int [][] dp = new int [days][2];
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                for(int i = 1;i < days;i ++){
                    dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
                    dp[i][1] = Math.max(dp[i-1][0] - prices[i],dp[i-1][1]);
                }
                return dp[days - 1][0];
            }
            else{
                int [][][] dp = new int [days][2][k+1];
                for(int i = 0;i < k+1;i++){
                    dp[0][0][i] = 0;
                    dp[0][1][i] = -prices[0];
                }
                // dp[0][0][0] = 0;
                // dp[0][0][1] = 0;
                // dp[0][0][2] = 0;
                // dp[0][1][0] = -prices[0];
                // dp[0][1][1] = -prices[0];
                // dp[0][1][2] = -prices[0];
                for(int i = 1;i < days; i++){
                    for(int j = 0;j <= k;j++){
                        if(j == k){
                            dp[i][1][j] = Math.max(dp[i-1][0][j]-prices[i],dp[i-1][1][j]);
                            continue;
                        }
                        else{
                            dp[i][0][j] = Math.max(dp[i-1][0][j],dp[i-1][1][j+1] + prices[i]);

                            dp[i][1][j] = Math.max(dp[i-1][0][j]-prices[i],dp[i-1][1][j]);
                        }
                    }
                }
                return dp[days - 1][0][0];
            }
        }
    }
}