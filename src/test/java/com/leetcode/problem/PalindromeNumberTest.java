package com.leetcode.problem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by YuBing on 2018/8/31.
 */
public class PalindromeNumberTest {

    private Map<Integer, Boolean> testCase = new HashMap<Integer, Boolean>();

    @Before
    public void loadTestCase(){
        testCase.put(121, true);
        testCase.put(1, true);
        testCase.put(-10, false);
        testCase.put(123, false);
    }
    @Test
    public void solution1() throws Exception {
        for(Map.Entry<Integer, Boolean> entry: testCase.entrySet()){
            Assert.assertEquals(entry.getValue(), PalindromeNumber.solution1(entry.getKey()));
        }
    }

}