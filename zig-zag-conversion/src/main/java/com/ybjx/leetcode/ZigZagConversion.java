package com.ybjx.leetcode;

/**
 * Created by YuBing on 2018/9/2.
 */
public class ZigZagConversion extends BaseSolution{
    public static String solution1(String str, int numRows){
        if(str.length() <= numRows || numRows == 1){
            return str;
        }
        StringBuilder builder = new StringBuilder();

        int count = numRows * 2 - 2;
        int n = str.length() / count + 1;
        int [][] map = new int[n * 2][numRows];

        for(int i = 0; i < str.length(); i++){
            int t = i / count * 2;
            int x = i % count;
            if(x >= numRows){
                t += 1;
                x = count - x;
            }
            map[t][x] = i;
        }
        builder.append(str.charAt(0));
        for(int i = 0; i < numRows;i++){
            for(int j = 0; j < 2*n;j++){
                if(map[j][i] > 0){
                    builder.append(str.charAt(map[j][i]));
                }
            }
        }

        return builder.toString();
    }

    public static String solution2(String str, int numRows){
        if(str.length() <= numRows || numRows == 1){
            return str;
        }
        StringBuilder builder = new StringBuilder();

        int count = numRows * 2 - 2;
        int n = str.length() / count + 1;
        int len = str.length();
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < n; j++) {
                if(i + j * count >= len){
                    break;
                }
                builder.append(str.charAt(i + j * count));
                if(i > 0 && i < numRows - 1){
                    if(2 * numRows -i - 2 + j * count >= len){
                        break;
                    }
                    builder.append(str.charAt(2 * numRows -i - 2 + j * count));
                }
            }
        }
        return builder.toString();
    }
}
