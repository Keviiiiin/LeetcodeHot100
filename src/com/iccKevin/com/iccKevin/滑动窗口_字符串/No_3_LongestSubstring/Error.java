package com.iccKevin.com.iccKevin.滑动窗口_字符串.No_3_LongestSubstring;

public class Error {

    //错误示范：只用一个指针，忽略了"dvdf"这种情况

    /*
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s == null || s.length() <= 0 )
                return 0;
            Set<Character> chs = new TreeSet<>();
            int i = 0;
            int len = 0;
            int max = 1;
            while(i < s.length()){
                Character ch = s.charAt(i);
                if(!chs.contains(ch)){
                    chs.add(ch);
                    len ++;
                    i++;
                }
                else{
                    if(len > max)
                        max = len;
                    len = 0;
                    chs.clear();
                }
            }
            return len>max?len:max;
        }
    }

     */
}
