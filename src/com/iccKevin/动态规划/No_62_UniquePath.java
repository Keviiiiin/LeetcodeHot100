package com.iccKevin.动态规划;

/**
 * @description: 左上到右下，只能向下或向右，共几条路径
 * @author: iccKevin
 * @create: 2020-05-17 20:52
 **/
public class No_62_UniquePath {
    static class MySolution {
        public int uniquePaths(int m, int n) {

            if(m == 0 || n == 0)
                return 0;

            int [][] path = new int [m][n];
            for(int i = 0;i < m; i++){
                path[i][0] = 1;
            }
            for(int j = 0;j < n; j++){
                path[0][j] = 1;
            }

            for(int i = 1; i < m; i ++){
                for(int j = 1; j < n; j ++){
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                }
            }
            return path[m - 1][n - 1];
        }
    }
}