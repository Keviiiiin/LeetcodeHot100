package com.iccKevin;

/*
    两数相加
 */


public class No_2_AddTwoNum {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode l = new ListNode(-1);
            ListNode iter = l;
            int carry = 0;
            int v1,v2;

            //防止99 + 1这种情况，高位为空则当成0
            while(l1 != null || l2 != null){

                v1 = l1 == null?0:l1.val;
                v2 = l2 == null?0:l2.val;
                int value = v1 + v2 + carry;
                carry = value/10;
                iter.next = new ListNode(value%10);
                iter = iter.next;
                if(l1 != null)
                    l1 = l1.next;
                if(l2 != null)
                    l2 = l2.next;
            }

            // 99 + 1 测试结果为 00，原因是最高位的carry未参与计算就结束了循环
            if(carry != 0)
                iter.next = new ListNode(carry);
            return l.next;
        }
    }
}
