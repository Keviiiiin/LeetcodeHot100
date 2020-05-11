package com.iccKevin.字符串.No_5_Palindromic.No_9_Palindromic_int;

public class ReverseHalf {
    // 复杂度为O(log10n)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0 || (x % 10 == 0 && x != 0)) return false;

            int revertedNumber = 0;
            // 将后半部分的数反转过来
            while (x > revertedNumber) {
                revertedNumber = revertedNumber * 10 + x % 10;
                x /= 10;
            }
            return x == revertedNumber || x == revertedNumber / 10;
        }
    }

//    作者：MisterBooo
//    链接：https://leetcode-cn.com/problems/palindrome-number/solution/dong-hua-hui-wen-shu-de-san-chong-jie-fa-fa-jie-ch/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
