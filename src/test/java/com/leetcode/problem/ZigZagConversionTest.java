package com.leetcode.problem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by YuBing on 2018/8/27.
 */
public class ZigZagConversionTest {
    private ZigZagConversion zigZagConversion = new ZigZagConversion();

    class TestCase{
        public int numRows;
        public String str;
        public String result;
        public TestCase(int numRows, String str, String result){
            this.numRows = numRows;
            this.str = str;
            this.result = result;
        }
    }

    private List<TestCase> testCaseList = new ArrayList<TestCase>();

    @Before
    public void loadTestCase(){
        testCaseList.add(new TestCase(3,"PAYPALISHIRING", "PAHNAPLSIIGYIR"));
        testCaseList.add(new TestCase(4, "PAYPALISHIRING", "PINALSIGYAHRPI"));
        testCaseList.add(new TestCase(4, "", ""));
        testCaseList.add(new TestCase(1, "A", "A"));
        testCaseList.add(new TestCase(1, "AB", "AB"));
        testCaseList.add(new TestCase(2, "ABCDE", "ACEBD"));
    }

    @Test
    public void solution1() throws Exception {
        for(TestCase testCase: testCaseList){
            Assert.assertEquals(testCase.result,zigZagConversion.solution1(testCase.str, testCase.numRows));
        }
    }


    @Test
    public void solution2() throws Exception {
        for(TestCase testCase: testCaseList){
            Assert.assertEquals(testCase.result,zigZagConversion.solution2(testCase.str, testCase.numRows));
        }
    }
}