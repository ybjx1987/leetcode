package com.ybjx.leetcode;

/**
 * Created by YuBing on 2018/9/16.
 */
public class TwoSum2 extends BaseSolution {

    public static int[] solution1(int[] numbers, int target){
        int m = 0, n = numbers.length - 1;
        while(m < n){
            int t = numbers[m] + numbers[n];
            if(t < target){
                m++;
            }
            if(t > target){
                n --;
            }
            if(t == target){
                return new int[]{m + 1, n + 1};
            }
        }
        return new int[] {0,0};
    }
}
