package com.leetcode.problem;

import java.util.HashMap;

/**
 * 题目：两数之和
 * 地址：https://leetcode-cn.com/problems/two-sum/description/
 */
public class TwoSum {

    /**
     * 通过两次遍历实现
     * 说明：该方法时间复杂度：O(n2)
     */
    public int[] solution1(int[] nums, int target){
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
    public int[] solution2(int [] nums, int target){
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

    /**
     * 结合HashMap一次遍历实现
     * 说明：这不是一种新的解法，但是相对与上一种实现，速度上有了巨大的提升
     *       从中我们可以看出for循环中定义变量的开销是非常大的
     */
    public int[] solution3(int [] nums, int target){
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
        int t;
        Integer p;
        for (int i = 0; i < nums.length; i++) {
            t = target - nums[i];
            p = temp.get(t);
            if (p != null) {
                return new int[]{p, i};
            } else {
                temp.put(nums[i], i);
            }
        }
        return new int[]{0,0};
    }
}
