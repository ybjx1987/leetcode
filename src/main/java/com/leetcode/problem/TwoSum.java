package com.leetcode.problem;

import java.util.HashMap;

/**
 * 题目：两数之和
 * 地址：https://leetcode-cn.com/problems/two-sum/description/
 * Created by YuBing on 2018/8/21.
 */
public class TwoSum {

    /**
     * 通过两次遍历实现
     * 说明：该方法时间复杂度：O(n2)
     */
    private static int[] solution1(int[] nums, int target){
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
    private static int[] solution2(int [] nums, int target){
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            int t = target - nums[i];
            Integer p = temp.get(t);
            if(p != null){
                return new int[]{p, i};
            }
            else{
                temp.put(nums[i], i);
            }
        }
        return new int[]{0,0};
    }

    /**
     * 结合HashMap一次遍历实现
     * 说明：只需要一次遍历，时间复杂度：O(n)
     */
    private static int[] solution3(int [] nums, int target){
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
        int t;
        Integer p;
        for(int i = 0; i < nums.length; i++){
            t = target - nums[i];
            p = temp.get(t);
            if(p != null){
                return new int[]{p, i};
            }
            else{
                temp.put(nums[i], i);
            }
        }
        return new int[]{0,0};
    }

    /**
     * 从数组中找到两个元素的和等于目标值，返回下标
     * @param nums 数组
     * @param target 目标值
     * @return 下标数组
     */
    private static int[] twoSum(int[] nums, int target) {
        // return solution1(nums, target);
        // return solution2(nums, target);
        return solution3(nums, target);
    }

    public static void main(String [] args) {
        int [] result;
        result = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(result[0] + "  "+ result[1]);
    }
}
