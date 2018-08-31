package com.leetcode.problem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by YuBing on 2018/8/30.
 */
public class StringToIntegerTest {
    private StringToInteger stringToInteger = new StringToInteger();

    private HashMap<String, Integer> testCase = new HashMap<String, Integer>();

    @Before
    public void loadTestCase(){
        testCase.put("42", 42);
        testCase.put("   -42", -42);
        testCase.put("4193 with words", 4193);
        testCase.put("words and 987", 0);
        testCase.put("-91283472332", Integer.MIN_VALUE);
        testCase.put("-2147483649", Integer.MIN_VALUE);
    }

    @Test
    public void solution1() throws Exception {
        for(Map.Entry<String, Integer> entry: testCase.entrySet()){
            Assert.assertEquals((long)entry.getValue(), (long)stringToInteger.solution1(entry.getKey()));
        }
    }

}