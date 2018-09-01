package com.leetcode.problem;

/**
 * Created by YuBing on 2018/9/1.
 */
public class ContainerWithMostWater {
    public static int solution1(int [] height){
        int max = 0;
        int temp;
        int length = height.length;
        for(int i = 0; i < length - 1; i++){
            for(int j = i; j < length; j++){
                temp = (height[i] > height[j] ? height[j]:height[i]) * (j - i);
                if(temp > max){
                    max = temp;
                }
            }
        }
        return max;
    }

    public static int solution2(int [] height){
        int max = 0;
        int temp;
        int length = height.length;
        for(int i = 0; i < length - 1; i++){
            if(height[i] == 0){
                continue;
            }
            int w = max / height[i];
            int p = i + w + 1;
            for(int j = length - 1; j >= p; j--){
                temp = (height[i] > height[j] ? height[j]:height[i]) * (j - i);
                if(temp > max){
                    max = temp;
                    w = max / height[i];
                    p = i + w + 1;
                }
            }
        }
        return max;
    }

    public static int solution3(int [] height){
        int i, j;
        i = 0;
        j = height.length - 1;
        int  max = 0;
        while(i != j){
            int temp = (height[i] > height[j] ? height[j] : height[i]) * (j - i);
            if(temp > max){
                max = temp;
            }
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return max;
    }
}
