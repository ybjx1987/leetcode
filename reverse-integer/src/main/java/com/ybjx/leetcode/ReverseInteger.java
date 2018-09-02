package com.ybjx.leetcode;

/**
 * Created by YuBing on 2018/9/2.
 */
public class ReverseInteger extends BaseSolution {

    public static int solution(int value){
        int r = 0;
        while(value != 0){

            int pop = value % 10;
            value /= 10;
            if (r > Integer.MAX_VALUE/10 || (r == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (r < Integer.MIN_VALUE/10 || (r == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            r = r * 10 + pop;

        }
        return r;
    }
}
