package com.iccKevin.动态规划.No_91_DecodeWays;

/**
 * @description:
 * @author: iccKevin
 * @create: 2020-05-17 21:52
 **/

/**
 * 错误统计：
 * 没考虑"01"
 * 没考虑int越界
 * 出现30 40 等应直接判0
 *
 * 代码冗余：
 * 为了不让i-2越界，i=1时判断次数太多，浪费编码时间
 *
 * 总结：其实只跟前两位有关，所有的情况都在两位数的范围内，分类讨论一下就行
 */
public class MySolution {
    public int numDecodings(String s) {
        // 1212
        // 2260
        // 322 10
        // 2200 0
        // 223 4
        if(s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        // int num = Integer.parseInt(s);
        if(s.length() <= 3){
            int result = judge(Integer.parseInt(s));
            if(result >= 0)
                return result;
        }
        int[] times = new int [s.length()];
        times[0] = 1;
        for(int i = 1; i < times.length; i++){
            int last = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if(last == 0 || (last % 10 == 0 && last > 20))
                return 0;
            if(i == 1)
                times[i] = judge(last);
            else if(last <= 10 || last == 20 )
                times[i] = times[i - 2];
            else if(last <= 26)
                times[i] = times[i - 2] + times[i - 1];
            else
                times[i] = times[i - 1];
        }
        return times[s.length() - 1];
    }
    private int judge(int num){
        if(num == 0 || (num % 10 == 0 && num > 20 && num < 100))
            return 0;
        else if(num < 11 || num == 20)
            return 1;
        else if(num <= 26)
            return 2;
        else if(num < 100)
            return 1;
        else
            return -1;
    }
}