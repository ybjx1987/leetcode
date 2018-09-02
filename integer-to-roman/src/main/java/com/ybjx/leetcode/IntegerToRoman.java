package com.ybjx.leetcode;

/**
 * Created by YuBing on 2018/9/2.
 */
public class IntegerToRoman extends BaseSolution{
    public static String solution1(int value){
        StringBuilder builder = new StringBuilder();
        int temp = value / 1000;
        for(int i = 0; i < temp; i++){
            builder.append("M");
        }
        value = value % 1000;
        if(value >= 900){
            builder.append("CM");
            value -= 900;
        }
        else if(value >= 500){
            builder.append("D");
            value -= 500;
        }
        else if(value >= 400){
            value -= 400;
            builder.append("CD");
        }
        temp = value / 100;
        for(int i = 0; i < temp; i++){
            builder.append("C");
        }
        value = value % 100;
        if(value >= 90){
            builder.append("XC");
            value -= 90;
        }
        else if(value >= 50){
            builder.append("L");
            value -= 50;
        }
        else if(value >= 40){
            value -= 40;
            builder.append("XL");
        }
        temp = value / 10;
        for(int i = 0; i < temp; i++){
            builder.append("X");
        }
        temp = value % 10;
        if(temp == 9){
            builder.append("IX");
            temp -= 9;
        }
        else if(temp >=5){
            builder.append("V");
            temp -= 5;
        }
        else if(temp == 4){
            builder.append("IV");
            temp -= 4;
        }
        for(int i = 0; i < temp; i++){
            builder.append("I");
        }
        return builder.toString();
    }
}
