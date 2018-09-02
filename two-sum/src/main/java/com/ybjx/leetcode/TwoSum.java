package com.ybjx.leetcode;

import java.util.HashMap;

/**
 * Created by YuBing on 2018/9/2.
 */
public class TwoSum extends BaseSolution{
    /**
     * 通过两次遍历实现
     * 说明：该方法时间复杂度：O(n2)
     */
    public static int[] solution1(int[] nums, int target){
        int [] result = new int[2];
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }

    /**
     * 结合HashMap一次遍历实现
     * 说明：只需要一次遍历，时间复杂度：O(n)
     */
    public static int[] solution2(int [] nums, int target){
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            int t = target - nums[i];
            Integer p = temp.get(t);
            if(p != null){
                return new int[]{p, i};
            } else {
                temp.put(nums[i], i);
            }
        }
        return new int[]{0,0};
    }
}