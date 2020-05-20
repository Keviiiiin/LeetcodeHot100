package com.iccKevin.动态规划.StockMarket;

/**
 * @description: 给爷整吐了..
 * @author: iccKevin
 * @create: 2020-05-20 21:27
 **/
public class No_123 {
        public int maxProfit_My(int[] prices) {
            if(prices == null || prices.length == 0)
                return 0;
            int days = prices.length;
            // 天数；是否持股；还剩几次交易
            int [][][] dp = new int [days][2][3];
            dp[0][0][0] = 0;
            dp[0][0][1] = 0;
            dp[0][0][2] = 0;
            dp[0][1][0] = -prices[0];
            dp[0][1][1] = -prices[0];
            dp[0][1][2] = -prices[0];
            for(int i = 1;i < days; i++){
                dp[i][0][0] = Math.max(dp[i-1][0][0],dp[i-1][1][1] + prices[i]);
                dp[i][0][1] = Math.max(dp[i-1][0][1],dp[i-1][1][2] + prices[i]);
//                dp[i][0][2] = dp[i-1][0][2];
//                dp[i][1][0] = Integer.MIN_VALUE;
                dp[i][1][1] = Math.max(dp[i-1][0][1]-prices[i],dp[i-1][1][1]);
                dp[i][1][2] = Math.max(dp[i-1][0][2]-prices[i],dp[i-1][1][2]);
            }
            return Math.max(Math.max(dp[days - 1][0][0],dp[days-1][0][1]),0);
        }
        public static void main(String[] args) {
            int[] t ={7,6,4,3,1};
            System.out.println(new No_123().maxProfit_My(t));
        }
    class Solution {
        public int maxProfit(int[] prices) {
            int dp_i01 = 0, dp_i11 = Integer.MIN_VALUE;
            int dp_i02 = 0, dp_i12 = Integer.MIN_VALUE;
            for (int price : prices) {
                dp_i02 = Math.max(dp_i02, dp_i12 + price);
                dp_i12 = Math.max(dp_i12, dp_i01 - price);
                dp_i01 = Math.max(dp_i01, dp_i11 + price);
                dp_i11 = Math.max(dp_i11, -price);
            }
            return dp_i02;
        }
    }
    public int maxProfit2(int[] prices) {
            if(prices.length == 0 || prices.length == 1){
                return 0;
            }
            int[][][] dp = new int[prices.length][2][3];
            /** * 定义第二位数组 【0】代表持股，【1】代表持股
             * * 定义第三维数组 【】代表已购买的次数，范围为0~2
             * * 【6】 种状态
             * * 1.持股，卖出0次
             * * 2.持股，卖出1次
             * * 3.持股，卖出2次
             * * 4.未持股，卖出0次
             * * 5.未持股，卖出1次
             * * 6.未持股，卖出2次 *
             * * 动态规划步骤：
             * * 1. 定义状态 * 2. 转移方程
             * * 3. 确定起始 * 4. 确定终了
             */
            // 第一天不买股票就是利润为0，第一天买股票就是利润为负
            dp[0][0][0] = 0;
            dp[0][0][1] = 0;
            dp[0][0][2] = 0;
            dp[0][1][0] = -prices[0];
            dp[0][1][1] = -prices[0];
            dp[0][1][2] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
            // 今天未持股，并且卖出次数为0，那么前一天一定没有买股票
                dp[i][0][0] = dp[i-1][0][0];
            // 今天未持股，并且卖出次数为1，那么前一天持股，今天卖出，或前一天未持股，今天未行动
                dp[i][0][1] = Math.max(dp[i-1][1][0]+prices[i],dp[i-1][0][1]);
                // 今天未持股，并且卖出次数为2，那么前一天持股，今天卖出，或前一天未持股，今天未行动
                 dp[i][0][2] = Math.max(dp[i-1][1][1]+prices[i],dp[i-1][0][2]);
                // 今天持股，卖出0次，那么前一天要么持股，今天未行动，要么前一天未持股，今天买入
                 dp[i][1][0] = Math.max(dp[i-1][1][0],dp[i-1][0][0]-prices[i]);
                // 今天持股，卖出1次，那么前一天要么持股，今天未行动，要么前一天未持股，今天买入
                 dp[i][1][1] = Math.max(dp[i-1][1][1],dp[i-1][0][1]-prices[i]);
                // 已经卖出两次了，利润不能变了，并且此状态还持有股票，是多余的
                 dp[i][1][2] = dp[i-1][1][2];
                 }
                 return Math.max(dp[prices.length-1][0][1], Math.max(dp[prices.length-1][0][2],0) );
                 }


    }