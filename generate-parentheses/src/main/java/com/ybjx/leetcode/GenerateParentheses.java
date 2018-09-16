package com.ybjx.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by YuBing on 2018/9/12.
 */
public class GenerateParentheses extends BaseSolution {

    private static void makeString(List<String> result, String str, int pos, int n){
        if(pos == n){
            Stack<Integer> stack = new Stack<Integer>();
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '('){
                    stack.push(1);
                }
                else{
                    if(stack.size() == 0){
                        return;
                    }
                    stack.pop();
                }
            }
            if(stack.size() == 0){
                result.add(str);
            }
        }
        else{
            makeString(result, str + "(", pos + 1, n);
            makeString(result, str + ")", pos + 1, n);
        }
    }

    public static List<String> solution1(int n){
        List<String> list = new ArrayList<String>();
        makeString(list, "", 0, n * 2);
        return list;
    }
}
