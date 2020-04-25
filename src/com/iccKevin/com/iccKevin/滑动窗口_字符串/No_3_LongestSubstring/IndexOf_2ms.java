package com.iccKevin.com.iccKevin.滑动窗口_字符串.No_3_LongestSubstring;

public class IndexOf_2ms {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s.length() < 1){ return 0; }
            int maxlen = 1;
            for(int head = 0, tail = 1; tail < s.length(); ++tail){
                int index = s.indexOf(s.charAt(tail), head);
                if(index < tail){
                    head += (index - head + 1);
                }
                int len = tail - head + 1;
                maxlen = len > maxlen ? len : maxlen;
            }
            return maxlen;
        }
    }
}
