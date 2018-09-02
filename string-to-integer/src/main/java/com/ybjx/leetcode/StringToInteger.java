package com.ybjx.leetcode;

/**
 * Created by YuBing on 2018/9/2.
 */
public class StringToInteger extends BaseSolution{

    public static int solution1(String str){
        int result = 0;
        int len = str.length();
        int tag = 0;
        for(int i= 0; i < len; i++){
            char ch = str.charAt(i);
            if(ch >= '0' && ch <= '9'){
                int t = ch - '0';
                if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && t > 7)) return Integer.MAX_VALUE;
                if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && t > 8)) return Integer.MIN_VALUE;
                if(tag == 0){
                    tag = 1;
                }
                result = result * 10 + t*tag;
                continue;
            }
            if(tag == 0){
                if(ch == '-'){
                    tag = -1;
                } else if(ch == '+'){
                    tag = 1;
                } else if(ch != ' '){
                    return result;
                }
            } else{
                return result;
            }
        }

        return result;
    }
}
