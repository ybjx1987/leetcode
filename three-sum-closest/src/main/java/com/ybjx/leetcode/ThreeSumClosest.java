package com.ybjx.leetcode;

import java.util.Arrays;

/**
 * Created by YuBing on 2018/9/2.
 */
public class ThreeSumClosest extends BaseSolution {
    public static int find(int [] value,int l, int r, int target){
        if(l > r){
            return -1;
        }
        int index = (r + l)/ 2;
        if(l == r && (index == l || value[l] == value[r])){
            return index;
        }
        int t = -1;
        if(value[index] > target){
            t = find(value, l, index - 1, target);
        }
        else if(index + 1 < value.length && target >= value[index + 1]){
            t = find(value, index + 1, r, target);
        }
        if(t == -1){
            return index;
        }
        else{
            return t;
        }
    }

    public static int solution1(int [] value, int target){
        Arrays.sort(value);

        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0; i <= value.length - 1; i++){
            for(int j = i + 1; j < value.length; j++){
                int c = target - value[i] - value[j];
                int index = find(value, i + 1, j - 1, c);
                if(index < 0){
                    continue;
                }
                if(Math.abs(c - value[index]) < min && index > i && index < j){
                    min = Math.abs(c - value[index]);
                    result = value[i] + value[j] + value[index];
                }
                if(index < value.length -1 && Math.abs(c - value[index + 1]) < min  && index + 1 > i && index + 1 < j){
                    min = Math.abs(c - value[index + 1]);
                    result = value[i] + value[j] + value[index + 1];
                }
            }
        }
        return result;
    }

    public static int solution2(int [] value, int target){
        Arrays.sort(value);

        int t = target / 3;
        int mid = find(value, 0, value.length - 1, t);
        while(mid > 0 && value[mid] == value[mid - 1]){
            mid --;
        }
        if(value.length - 1 ==  mid){
            return value[mid - 2] + value[mid - 1] + value[mid];
        }

        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0; i <= mid; i++){
            for(int j = mid + 1 ; j < value.length; j++){
                int c = target - value[i] - value[j];
                int index = find(value, i + 1, j - 1, c);
                if(index < 0){
                    continue;
                }
                if(Math.abs(c - value[index]) < min && index > i && index < j){
                    min = Math.abs(c - value[index]);
                    result = value[i] + value[j] + value[index];
                }
                if(index < value.length -1 && Math.abs(c - value[index + 1]) < min  && index + 1 > i && index + 1 < j){
                    min = Math.abs(c - value[index + 1]);
                    result = value[i] + value[j] + value[index + 1];
                }
            }
        }
        return result;
    }
}
