package com.iccKevin.动态规划.No_91_DecodeWays;

/**
 * @description: 极简写法
 * @author: iccKevin
 * @create: 2020-05-17 22:54
 **/

/**
 * 因为只跟前两位有关系，故可以用单变量代替dp[]数组
 * 用当前循环中的curr代替dp[i]，当前循环中的pre代替dp[i - 1]
 * 循环结束时将tmp中存储的curr值赋给pre，并根据不同的情况更新curr的值
 * 总共有这么几种情况：
 * 01-09
 * 10、20
 * 11-26
 * 30、40、50等
 * >26的
 */
public class BestSolution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int pre = 1, curr = 1;//dp[-1] = dp[0] = 1
        for (int i = 1; i < s.length(); i++) {
            int tmp = curr;
            if (s.charAt(i) == '0')
                if (s.charAt(i - 1)== '1' || s.charAt(i - 1)== '2') curr = pre;
                else return 0;
            else if (s.charAt(i - 1)== '1' || (s.charAt(i - 1)== '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6'))
                curr = curr + pre;
            pre = tmp;
        }
        return curr;
    }

//    作者：pris_bupt
//    链接：https://leetcode-cn.com/problems/decode-ways/solution/c-wo-ren-wei-hen-jian-dan-zhi-guan-de-jie-fa-by-pr/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}