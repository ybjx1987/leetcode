package com.ybjx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YuBing on 2018/9/2.
 */
public class LetterCombinationsOfAPhoneNumber extends BaseSolution{

    private static String [][] map;
    static{
        map = new String[8][4];
        for(int i = 0; i < 8; i++){
            int t = i * 3;
            if(i > 5){
                t += 1;
            }
            map[i][0] = new String(new char[]{(char)('a' + t)});
            map[i][1] = new String(new char[]{(char)('a' + t + 1)});
            map[i][2] = new String(new char[]{(char)('a' + t + 2)});
            if(i == 5 || i == 7){
                map[i][3] = new String(new char[]{(char)('a' + t + 3)});
            }
        }
    }

    public static List<String> getString(int [] data,int index){
        if(index >= data.length){
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < ((data[index] == 5 || data[index] == 7) ? 4 : 3); i++){
            List<String> list = getString(data, index + 1);
            if(list.size() > 0) {
                for (String s : list) {
                    result.add(map[data[index]][i] + s);
                }
            }
            else{
                result.add(map[data[index]][i]);
            }
        }
        return result;
    }

    public static List<String> solution1(String digits){
        int [] data = new int[digits.length()];
        for(int i = 0; i < digits.length(); i++){
            data[i] = (digits.charAt(i) - '2');
        }
        return getString(data, 0);
    }
}
