package com.ybjx.leetcode;

/**
 * Created by YuBing on 2018/9/2.
 */
public class PalindromeNumber extends BaseSolution{
    public static boolean solution1(int value){
        if(value < 0 || (value % 10 == 0  && value > 0)){
            return false;
        }

        int result = 0;
        int temp = value;
        while(temp > 0){
            result = result * 10 + (temp % 10);
            temp = temp / 10;
            if(result == temp){
                return true;
            }
        }
        return result == value;
    }
}
