package com.iccKevin.字符串.No_12_IntegerToRoman;

public class MySolution {
    // 我的思路：每一位数字按照123 4 5678 9进行分类
    public String intToRoman(int num) {
        String maps[][] = {{"I","V"},{"X","L"},{"C","D"},{"M",null}};
        int [] nums = new int [4];
        int tmpNum = num;
        int i = 0;
        while(tmpNum != 0){
            nums[i++] = tmpNum % 10;
            tmpNum /= 10;
        }
        StringBuilder sb = new StringBuilder();
        while(nums[3]-- != 0)
            sb.append(maps[3][0]);
        for(i = 2;i >= 0 ;i --){
            if(nums[i] < 4)
                while(nums[i]-- != 0)
                    sb.append(maps[i][0]);
            else if(nums[i] == 4)
                sb.append(maps[i][0]).append(maps[i][1]);
            else if (nums[i] < 9){
                sb.append(maps[i][1]);
                while(nums[i] - 5 != 0){
                    sb.append(maps[i][0]);
                    nums[i]--;
                }
            }
            else{
                sb.append(maps[i][0]).append(maps[i+1][0]);
            }
        }
        return sb.toString();
    }
}
