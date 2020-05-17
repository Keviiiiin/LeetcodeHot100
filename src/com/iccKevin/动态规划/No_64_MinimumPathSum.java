package com.iccKevin.动态规划;

/**
 * @description: 给定一个矩阵，求左上到右下的最短路径
 * @author: iccKevin
 * @create: 2020-05-17 20:54
 **/
public class No_64_MinimumPathSum {
    class MySolution {
        //  [1,3,1],
        //  [1,5,1],
        //  [4,2,1]
        public int minPathSum(int[][] grid) {
            // 1 4 5
            // 2 7 6
            // 6 8 7
            if(grid.length == 0)
                return 0;
            int row = grid.length;
            int col = grid[0].length;
            int[][] sum = new int [row][col];
            sum[0][0] = grid[0][0];

            for(int i = 1; i < col; i++){
                sum[0][i] = grid[0][i] + sum[0][i - 1];
            }
            for(int j = 1; j < row; j++){
                sum[j][0] = grid[j][0] + sum[j - 1][0];
            }

            for(int i = 1 ;i < row;i++){
                for(int j = 1; j < col ; j ++){
                    sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
                }
            }
            return sum[row - 1][col - 1];
        }
    }
}