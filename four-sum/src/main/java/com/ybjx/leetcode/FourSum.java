package com.ybjx.leetcode;

import java.util.*;

/**
 * Created by YuBing on 2018/9/2.
 */
public class FourSum extends BaseSolution {
    /**
     * 会超时，时间复杂度：O(n4)
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> solution1(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<String> cache = new HashSet<String>();
        for(int a = 0; a < nums.length - 3; a++){
            for(int b = a + 1; b < nums.length - 2; b++){
                for(int c = b + 1; c < nums.length - 1; c++){
                    for(int d = c + 1; d < nums.length; d++){
                        if(target == nums[a] + nums[b] + nums[c] + nums[d]){
                            String str = nums[a] + "," + nums[b] + "," + nums[c] + "," + nums[d];
                            if(!cache.contains(str)){
                                List<Integer> list = new ArrayList<Integer>();
                                list.add(nums[a]);
                                list.add(nums[b]);
                                list.add(nums[c]);
                                list.add(nums[d]);
                                result.add(list);
                                cache.add(str);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    public static List<List<Integer>> solution2(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<String> cache = new HashSet<String>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for(int a = 0; a < nums.length - 3; a++){
            for(int b = a + 1; b < nums.length - 2; b++){
                for(int c = b + 1; c < nums.length - 1; c++){
                    int t = target - nums[a] - nums[b] - nums[c];
                    if(t < nums[c]){
                        break;
                    }
                    int count = 1 + (nums[a]==t?1:0) + (nums[b]==t?1:0) + (nums[c]==t?1:0);
                    if(map.containsKey(t) && map.get(t) >= count){
                        String str = nums[a] + "," + nums[b] + "," + nums[c] + "," + t;
                        if(!cache.contains(str)){
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(nums[a]);
                            list.add(nums[b]);
                            list.add(nums[c]);
                            list.add(t);
                            result.add(list);
                            cache.add(str);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> solution3(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<String> cache = new HashSet<String>();
        for(int a = 0; a < nums.length - 3; a++){
            for(int b = a + 1; b < nums.length - 2; b++){
                int i = b + 1;
                int j = nums.length - 1;
                int t = target - nums[a] - nums[b];
                while (i < j){
                    int k = nums[i] + nums[j];
                    if( k == t){
                        String str = nums[a] + "," + nums[b] + "," + nums[i] + "," + nums[j];
                        if(!cache.contains(str)){
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(nums[a]);
                            list.add(nums[b]);
                            list.add(nums[i]);
                            list.add(nums[j]);
                            result.add(list);
                            cache.add(str);
                        }
                        i++;
                        j--;
                    } else if (k < t){
                        i++;
                    } else if(k > t){
                        j --;
                    }
                }
            }
        }
        return result;
    }
}
