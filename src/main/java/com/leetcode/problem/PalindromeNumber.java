package com.leetcode.problem;

/**
 * Created by YuBing on 2018/8/31.
 */
public class PalindromeNumber {
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
