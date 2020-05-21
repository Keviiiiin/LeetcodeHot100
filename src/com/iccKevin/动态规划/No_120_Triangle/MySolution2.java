package com.iccKevin.动态规划.No_120_Triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: iccKevin
 * @create: 2020-05-21 15:13
 **/
public class MySolution2 {
    /**
     * 时间复杂度O(n2)
     * 空间复杂度O(n2)
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1)
            return triangle.get(0).get(0);
        int row = triangle.size();
        int [][]sum = new int [row][row];
        sum[0][0] = triangle.get(0).get(0);
        for(int i = 1;i < row;i++){
            for(int j = 0;j <= i;j++){
                if(j == 0)
                    sum[i][0] = sum[i-1][0] + triangle.get(i).get(j);
                else if(j == i)
                    sum[i][i] = sum[i-1][i-1] + triangle.get(i).get(j);
                else{
                    sum[i][j] = triangle.get(i).get(j) + Math.min(sum[i-1][j],sum[i-1][j-1]);
                }
            }
        }
        int res = sum[row - 1][0];
        for(int i = 0;i < row;i++){
            res = Math.min(res,sum[row-1][i]);
        }
        return res;
    }

    /**
     * 空间复杂度O(n)
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        // 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // dp最大长度==triangle底边长度
        // 题意：只使用 O(n) 的额外空间（n 为三角形的总行数）
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);

        // prev暂存dp[i-1][j-1],cur暂存dp[i-1][j]
        int prev = 0, cur;
        for (int i = 1; i < triangle.size(); i++) {
            //对每一行的元素进行推导
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                cur = dp[j];
                if (j == 0) {
                    // 最左端特殊处理
                    dp[j] = cur + rows.get(j);
                } else if (j == i) {
                    // 最右端特殊处理
                    dp[j] = prev + rows.get(j);
                } else {
                    dp[j] = Math.min(cur, prev) + rows.get(j);
                }
                prev = cur;
            }
        }

        int res = Integer.MAX_VALUE;
        // dp最后一行记录了最小路径
        for (int i = 0; i < triangle.size(); i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }

//    public static void main(String[] args) {
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(-1);
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(2);
//        list2.add(3);
//        List<Integer> list3 = new ArrayList<>();
//        list3.add(1);
//        list3.add(-1);
//        list3.add(-3);
//        List<List<Integer>> lists = new ArrayList<>();
//        lists.add(list1);
//        lists.add(list2);
//        lists.add(list3);
//        System.out.println(new MySolution2().minimumTotal2(lists));
//    }
}