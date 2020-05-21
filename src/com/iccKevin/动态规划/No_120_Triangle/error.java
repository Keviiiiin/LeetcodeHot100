package com.iccKevin.动态规划.No_120_Triangle;

import java.util.List;

/**
 * @description:当前最小并不是最终最小
 * @author: iccKevin
 * @create: 2020-05-21 15:11
 **/
public class error {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1)
            return triangle.get(0).get(0);
        int row = triangle.size();
        int [] sum = new int [row];
        sum[0] = triangle.get(0).get(0);
        int num = 0;
        for(int i = 1;i < row; i++){
            num = triangle.get(i).get(num) > triangle.get(i).get(num + 1)? num + 1 : num ;
            sum[i] = sum[i - 1] + triangle.get(i).get(num);
        }
        return sum[row - 1];
    }
}
