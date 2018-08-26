package com.leetcode.problem;

/**
 * 题目：无重复字符的最大子串
 * 地址：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 * Created by YuBing on 2018/8/22.
 */
public class LongestSubstring {

    /**
     * 暴力破解，直接循环解决
     * 说明：时间复杂度O(n3)
     */
    public int solution1(String s){
        int result = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = start; j < i; j++){
                if(s.charAt(i) == s.charAt(j)){
                    start = j + 1;
                    break;
                }
            }
            if(i - start + 1 > result){
                result = i - start + 1;
            }
        }
        return result;
    }

    /**
     * 通过映射完成遍历查找
     * 说明：时间复杂度O(n)
     */
    public int solution2(String s){
        int result = 0;
        int start = 0;
        int [] pos = new int[128];
        int temp,i;
        int len = s.length();
        if(len < 2){
            return len;
        }
        for(i = 0; i < len; i++){
            temp = s.charAt(i);
            if(pos[temp] >= start){
                start = pos[temp];
            }
            pos[temp] = i + 1;
            if(i - start + 1 > result){
                result = i - start + 1;
            }
        }
        return result;
    }
}
