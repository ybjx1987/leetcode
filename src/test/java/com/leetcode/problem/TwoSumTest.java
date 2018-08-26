package com.leetcode.problem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YuBing on 2018/8/26.
 */
public class TwoSumTest {
    private TwoSum twoSum = new TwoSum();

    class TestCase{
        int[] data;
        int target;
        int [] result;
    }

    private List<TestCase> testCaseList = new ArrayList<TestCase>();

    @Before
    public void loadTestCase(){
        TestCase testCase = new TestCase();
        testCase.data = new int[]{3, 2, 4};
        testCase.target = 6;
        testCase.result = new int[]{1,2};
        testCaseList.add(testCase);

        testCase = new TestCase();
        testCase.data = new int[]{6, 12, 8, 11,2};
        testCase.target = 13;
        testCase.result = new int[]{3,4};
        testCaseList.add(testCase);
    }

    @Test
    public void solution1() throws Exception {
        for(TestCase testCase: testCaseList) {
            Assert.assertArrayEquals(testCase.result,twoSum.solution1(testCase.data, testCase.target));
        }
    }

    @Test
    public void solution2() throws Exception {
        for(TestCase testCase: testCaseList) {
            Assert.assertArrayEquals(testCase.result,twoSum.solution2(testCase.data, testCase.target));
        }
    }

    @Test
    public void solution3() throws Exception {
        for(TestCase testCase: testCaseList) {
            Assert.assertArrayEquals(testCase.result,twoSum.solution3(testCase.data, testCase.target));
        }
    }

}