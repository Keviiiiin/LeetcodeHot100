package com.iccKevin.字符串.No_5_Palindromic.No_9_Palindromic_int;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断是不是回文
 * 注意：输入是 int
 */
public class MySolution_On {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int tmp = x;
        List<Integer> num = new ArrayList<>();
        while(tmp != 0){
            num.add(tmp%10);
            tmp /= 10;
        }
        int len = num.size();
        int times = 1;
        // 倒过来加起来看和原来的数是不是一样
        for(int i = len - 1;i >= 0 ;i--){
            tmp += num.get(i) * times;
            times *= 10;
        }
        return tmp == x;
    }

    public static void main(String[] args) {
//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.add(12);
//        integers.add(123);
//        integers.add(542);
//        for (int i = 0; i < integers.size(); i++) {
//            System.out.println(integers.get(i));
//        }
        boolean b = new MySolution_On().isPalindrome(2147483647);
    }
}
