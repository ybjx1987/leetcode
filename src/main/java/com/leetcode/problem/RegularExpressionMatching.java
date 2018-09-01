package com.leetcode.problem;

/**
 * Created by YuBing on 2018/8/31.
 */
public class RegularExpressionMatching {

    public static boolean check(String s, String p, int sIndex, int pIndex){
        if(s.length() == sIndex && p.length() == pIndex){
            return true;
        }
        if(p.length() == pIndex){
            return false;
        }
        char pc = p.charAt(pIndex);
        if(s.length() == sIndex){
            if(pc == '+' || (pc >= 'A' && pc <= 'Z')){
                return check(s, p, sIndex, pIndex + 1);
            }
            else{
                return false;
            }
        }
        else{
            char sc = s.charAt(sIndex);
            if(sc == pc || pc == '.'){
                return check(s, p, sIndex + 1, pIndex + 1);
            }
            else if(sc == pc + 32 || pc == '+'){
                if(check(s, p, sIndex + 1, pIndex)){
                    return true;
                }
                else{
                    if(check(s, p, sIndex + 1, pIndex + 1)){
                        return true;
                    }
                    else{
                        return check(s, p, sIndex, pIndex+ 1);
                    }
                }
            }
            else{
                if(pc >= 'A' && pc <= 'Z'){
                    return check(s, p, sIndex, pIndex + 1);
                }
                else{
                    return false;
                }
            }
        }
    }

    public static boolean solution1(String s, String p){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) != '*'){
                builder.append(p.charAt(i));
            }
            else{
                if(i > 0){
                    char c = p.charAt(i - 1);
                    if(c == '.'){
                        builder.deleteCharAt(builder.length() - 1);
                        while(builder.length() > 0){
                            char ch = builder.charAt(builder.length() - 1);
                            if(ch == '+' || (ch >= 'A' && ch <= 'Z')){
                                builder.deleteCharAt(builder.length() - 1);
                            }
                            else{
                                break;
                            }
                        }
                        builder.append("+");
                    }
                    else if(c != '*'){
                        builder.deleteCharAt(builder.length() - 1);
                        if(builder.length() == 0 || (builder.charAt(builder.length() - 1) != (c - 32) && builder.charAt(builder.length() - 1) != '+')) {
                            builder.append((char) (c - 32));
                        }
                    }
                }
            }
        }

        return check(s, builder.toString(), 0,0);
    }
}
