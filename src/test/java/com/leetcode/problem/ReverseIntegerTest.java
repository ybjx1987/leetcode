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
public class ReverseIntegerTest {
    private ReverseInteger reverseInteger = new ReverseInteger();

    private HashMap<Integer, Integer> testCase = new HashMap<Integer, Integer>();

    @Before
    public void loadTestCase(){
        testCase.put(1, 1);
        testCase.put(123, 321);
        testCase.put(120, 21);
        testCase.put(-120, -21);
        testCase.put(1<<31 - 1, 0);
        testCase.put(1534236469, 0);
        testCase.put(463847412, 214748364);
        testCase.put(563847412, 214748365);
        testCase.put(-2147483648, 0);
    }

    @Test
    public void solution() throws Exception {
        for(Map.Entry<Integer, Integer> entry: testCase.entrySet()){
            Assert.assertEquals((long)reverseInteger.solution(entry.getKey()), (long)entry.getValue());
        }
    }

}