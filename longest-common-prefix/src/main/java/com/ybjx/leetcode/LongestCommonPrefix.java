package com.ybjx.leetcode;

/**
 * Created by YuBing on 2018/9/2.
 */
public class LongestCommonPrefix extends BaseSolution{
    public static String solution(String [] list){
        if(list.length == 0){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while(true){
            char c = 0;
            for (String aList : list) {
                if (index >= aList.length()) {
                    return builder.toString();
                }
                if (c == 0) {
                    c = aList.charAt(index);
                } else {
                    if (c != aList.charAt(index)) {
                        return builder.toString();
                    }
                }
            }
            index ++;
            builder.append(c);
        }
    }
}
