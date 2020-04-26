package com.iccKevin.com.iccKevin.字符串.滑动窗口.No_3_LongestSubstring;

import java.util.HashMap;
import java.util.Map;

public class HashMap_7ms {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s == null || s.length() <= 0)
                return 0;

            Map<Character,Integer> mp = new HashMap<>();
            int left = 0, right = 0;
//            int len = 0;
            int max = 0;

            //两种情况
            while(right < s.length()){
                Character c = s.charAt(right);

                /*
                    1.重复了，指针left要变动，长度max要记录，hashmap要处理left左边的字符
                    （可以remove key，但那样相当于逐步增加左指针，就失去了left = mp.get(c)的意义）
                    2.没重复，hashmap里放元素、记录长度

                    结合qwereqwk这种情况，遇到第二个q时，属于情况1，但left不可能变到第一个w那里，
                    所以可以给left的变动加个判断，防止这种情况下left回溯

                 */
                if(mp.containsKey(c)){
                    left = Math.max(mp.get(c) + 1,left);
                }
                mp.put(c,right);
                max = Math.max(max,right - left + 1);
                right++;
            }
            return max;
        }
    }
}
