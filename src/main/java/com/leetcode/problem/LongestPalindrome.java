package com.leetcode.problem;

/**
 * Created by YuBing on 2018/8/26.
 */
public class LongestPalindrome {
    /**
     * 中心扩展法
     * 时间复杂度：O(n2)
     */
    public String solution1(String str){
        String result = "";
        int len = str.length();
        int resultLen = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j <= i && j + i< len; j++){
                if(str.charAt(i - j) != str.charAt(i + j)){
                    if(2 * (j - 1) + 1 > resultLen){
                        result = str.substring(i -j + 1,i + j);
                        resultLen = result.length();
                    }
                    break;
                }
                if(j == i || j + i == len - 1){
                    if(2 * j + 1 > resultLen){
                        result = str.substring(i -j,i + j + 1);
                        resultLen = result.length();
                    }
                    if(j + i == len - 1){
                        return result;
                    }
                }
            }
            if(i + 1 < str.length()){
                for(int j = 0; j <= i && j + i + 1 < len; j++){
                    if(str.charAt(i -j) != str.charAt(i + j + 1)){
                        if(2 * j > resultLen){
                            result = str.substring(i - j + 1, i +j + 1);
                            resultLen = result.length();
                        }
                        break;
                    }
                    if(j == i || j + i + 1 == len - 1){
                        if(2 * (j + 1) > resultLen){
                            result = str.substring(i - j, i + j + 2);
                            resultLen = result.length();
                        }
                        if(j + i + 1 == len - 1){
                            return result;
                        }
                    }
                }
            }
        }

        return result;
    }
}
