package com.leetcode.problem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by YuBing on 2018/8/26.
 */
public class LongestSubstringTest {
    private LongestSubstring longestSubstring = new LongestSubstring();
    Map<String, Integer> testCase = new HashMap<String, Integer>();

    @Before
    public void loadTestCase(){
        testCase.put("abcabcbb",3);
        testCase.put("bbbbb",1);
        testCase.put("pwwkew",3);
        testCase.put(" ",1);
    }

    @Test
    public void solution1() throws Exception {
        for(Map.Entry<String,Integer> entry: testCase.entrySet()){
            Assert.assertEquals((long)entry.getValue(), (long)longestSubstring.solution1(entry.getKey()));
        }
    }

    @Test
    public void solution2() throws Exception {
        for(Map.Entry<String,Integer> entry: testCase.entrySet()){
            Assert.assertEquals((long)entry.getValue(), (long)longestSubstring.solution2(entry.getKey()));
        }
    }

}