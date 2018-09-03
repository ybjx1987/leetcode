package com.ybjx.leetcode;

import java.util.Stack;

/**
 * Created by YuBing on 2018/9/3.
 */
public class ValidParentheses extends BaseSolution {
    public static boolean solution1(String s){
        Stack<Byte> stack = new Stack<Byte>();
        byte [] b = s.getBytes();
        for (int i = 0; i < b.length; i ++) {
            if(b.length - i < stack.size()){
                return false;
            }
            if (b[i] == '(' || b[i] == '[' || b[i] == '{') {
                stack.push(b[i]);
            } else {
                if(stack.size() == 0){
                    return false;
                }
                Byte bt = stack.pop();
                if (!((b[i] == ')' && bt == '(') || (b[i] == ']' && bt == '[') || (b[i] == '}' && bt == '{'))) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public static boolean solution2(String s){
        byte [] b = s.getBytes();
        byte [] t = new byte[b.length];
        int index = -1;
        for (int i = 0; i < b.length; i ++) {
            if(b.length - i < index){
                return false;
            }
            if (b[i] == '(' || b[i] == '[' || b[i] == '{') {
                index ++;
                t[index] = b[i];
            } else {
                if(index == -1){
                    return false;
                }
                if (!((b[i] == ')' && t[index] == '(') || (b[i] == ']' && t[index] == '[') || (b[i] == '}' && t[index] == '{'))) {
                    return false;
                }
                index--;
            }
        }
        return index == -1;
    }
}
