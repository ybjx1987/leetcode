package com.ybjx.leetcode;

import java.util.*;

/**
 * Created by YuBing on 2018/9/2.
 */
public class ThreeSum extends BaseSolution {
    public static List<List<Integer>> solution1(int [] value){
        Arrays.sort(value);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int aValue : value) {
            if (map.containsKey(aValue)) {
                map.put(aValue, map.get(aValue) + 1);
            } else {
                map.put(aValue, 1);
            }
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<String> cache = new HashSet<String>();
        for(int i = 0; i < value.length - 2; i++){
            int x = value[i];
            if(x > 0){
                break;
            }

            for(int j = i + 1; j < value.length - 1; j++){
                int y = value[j];
                if(x + y > 0){
                    break;
                }
                if(x + value[value.length - 2] + value[value.length - 1] < 0){
                    continue;
                }
                if(x + y + value[value.length - 1] < 0){
                    continue;
                }
                int z = -x - y;
                if(z < y){
                    break;
                }
                int c = 1 + (x == z ? 1 : 0) + (y == z ? 1: 0);
                if(map.containsKey(z) && map.get(z) >= c){
                    String str = String.valueOf(x) + y + z;
                    if(!cache.contains(str)){
                        List<Integer> ll = new ArrayList<Integer>();
                        ll.add(x);
                        ll.add(y);
                        ll.add(z);
                        result.add(ll);
                        cache.add(str);
                    }
                }
            }
        }
        return result;
    }
}
