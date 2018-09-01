package com.leetcode.problem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by YuBing on 2018/9/1.
 */
public class RomanToIntegerTest {
    private Map<String, Integer> testCase = new HashMap<String, Integer>();

    @Before
    public void loadTestCase(){
        testCase.put("III", 3);
        testCase.put("IV", 4);
        testCase.put("IX", 9);
        testCase.put("LVIII", 58);
        testCase.put("MCMXCIV", 1994);
        testCase.put("X", 10);
    }

    @Test
    public void solution1() throws Exception {
        for(Map.Entry<String, Integer> entry: testCase.entrySet()){
            Assert.assertEquals((long)entry.getValue(), RomanToInteger.solution1(entry.getKey()));
        }
    }

    @Test
    public void solution2() throws Exception {
        for(Map.Entry<String, Integer> entry: testCase.entrySet()){
            Assert.assertEquals((long)entry.getValue(), RomanToInteger.solution2(entry.getKey()));
        }
    }

}