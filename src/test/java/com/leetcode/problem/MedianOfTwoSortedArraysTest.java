package com.leetcode.problem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YuBing on 2018/8/26.
 */
public class MedianOfTwoSortedArraysTest {
    private MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
    class TestCase{
        int [] nums1;
        int [] nums2;
        double result;
        public TestCase(int [] nums1, int [] nums2, double result){
            this.nums1 = nums1;
            this.nums2 = nums2;
            this.result = result;
        }
    }
    private List<TestCase> testCaseList = new ArrayList<TestCase>();

    @Before
    public void loadTestCase(){
        testCaseList.add(new TestCase(new int[]{1, 3}, new int []{2}, 2.0));
        testCaseList.add(new TestCase(new int[]{1, 2}, new int []{3,4}, 2.5));
        testCaseList.add(new TestCase(new int[]{}, new int []{1}, 1.0));
        testCaseList.add(new TestCase(new int[]{}, new int []{1,2}, 1.5));
        testCaseList.add(new TestCase(new int[]{3}, new int []{1,2,4}, 2.5));
        testCaseList.add(new TestCase(new int[]{3,7}, new int []{1,2,4}, 3.0));
    }

    @Test
    public void solution1() throws Exception {
        for(TestCase testCase: testCaseList){
            Assert.assertEquals(Double.valueOf(testCase.result),Double.valueOf(medianOfTwoSortedArrays.solution1(testCase.nums1, testCase.nums2)));
        }
    }

}