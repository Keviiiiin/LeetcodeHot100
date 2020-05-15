package com.iccKevin.动态规划;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: iccKevin
 * @create: 2020-05-15 17:02
 **/
public class No_139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet<>();
        for(int i = 0;i < wordDict.size(); i++){
            st.add(wordDict.get(i));
        }
        boolean[] flag = new boolean[s.length()+1];
        flag[0] = true;
        for(int i = 1; i <= s.length();i++){
            for(String word: st){
                if(i - word.length() >= 0 && flag[i-word.length()] && word.equals(s.substring(i-word.length(),i))){
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[s.length()];
    }
}