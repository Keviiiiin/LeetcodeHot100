package com.iccKevin.动态规划.StockMarket;

/**
 * @description:
 * @author: iccKevin
 * @create: 2020-05-20 22:11
 **/
public class No_121 {
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length == 0)
                return 0;
            int days = prices.length;
            // 所有的状态，0表示未持有股票，1表示持有股票
            int [][] dp = new int [days][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for(int i = 1;i < days; i++){
                dp[i][0] = Math.max(dp[i - 1][0] , dp[i - 1][1] + prices[i]);
                /**
                 * 注意这里，如果前一天未持有股票，利润是要从今天开始重新计算的
                 */
                dp[i][1] = Math.max(-prices[i] , dp[i - 1][1]);

            }
            return dp[days - 1][0];
        }
    }
}