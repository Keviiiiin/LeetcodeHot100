package com.iccKevin.com.iccKevin.字符串.滑动窗口.No_3_LongestSubstring;

public class ASCII_3ms {
    public class Solution {

        /*
        以前的我们都没有对字符串 s 所使用的字符集进行假设。

        当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。

        常用的表如下所示：

        int [26] 用于字母 ‘a’ - ‘z’ 或 ‘A’ - ‘Z’
        int [128] 用于ASCII码
        int [256] 用于扩展ASCII码


         */
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;

            // 数组的索引代表字符的ASCII码值，值是字符的索引 + 1
            // 不产生哈希冲突的时候可以这样用
            int[] index = new int[128];


            for (int j = 0, i = 0; j < n; j++) {

                // i 只能变大
                // 与hashmap不同的是，不需要判断容器中是否有字符，因为数组已经初始化好
                // 值得注意的是，index数组存放的是索引值 + 1，以区分初始值0
                i = Math.max(index[s.charAt(j)], i);
                ans = Math.max(ans, j - i + 1);
                index[s.charAt(j)] = j + 1;
            }
            return ans;
        }
    }

}
