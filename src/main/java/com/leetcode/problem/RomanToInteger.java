package com.leetcode.problem;

/**
 * Created by YuBing on 2018/9/1.
 */
public class RomanToInteger {
    public static int solution1(String value){
        int result = 0;
        int len = value.length();
        int last = 0;
        for(int i = len -1; i >= 0; i--){
            char c = value.charAt(i);
            int temp = 0;
            switch (c){
                case 'I':
                    temp = 1;
                    break;
                case 'V':
                    temp = 5;
                    break;
                case 'X':
                    temp = 10;
                    break;
                case 'L':
                    temp = 50;
                    break;
                case 'C':
                    temp = 100;
                    break;
                case 'D':
                    temp = 500;
                    break;
                case 'M':
                    temp = 1000;
                    break;
            }
            if(temp < last){
                result -= temp;
            }
            else{
                result += temp;
                last = temp;
            }
        }
        return result;
    }

    public static int solution2(String value){
        int result = 0;
        int len = value.length();
        int last = 0;
        int [] map = new int[128];
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
        for(int i = len -1; i >= 0; i--){
            int temp = map[value.charAt(i)];
            if(temp < last){
                result -= temp;
            }
            else{
                result += temp;
                last = temp;
            }
        }
        return result;
    }
}
