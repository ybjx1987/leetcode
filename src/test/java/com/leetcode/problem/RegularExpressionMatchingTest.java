package com.leetcode.problem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YuBing on 2018/8/31.
 */
public class RegularExpressionMatchingTest {
    class TestCase{
        public String s;
        public String p;
        public boolean result;

        public TestCase(String s, String p, boolean result){
            this.s = s;
            this.p = p;
            this.result = result;
        }
    }

    List<TestCase> testCases = new ArrayList<TestCase>();

    @Before
    public void loadTestCase(){
        testCases.add(new TestCase("b", "aaa.", false));
        testCases.add(new TestCase("ab", ".*c", false));
        testCases.add(new TestCase("aa", "a", false));
        testCases.add(new TestCase("aa", "a*", true));
        testCases.add(new TestCase("ab", ".*", true));
        testCases.add(new TestCase("aab", "a*b*c*", true));
        testCases.add(new TestCase("mississippi", "mis*is*p*.", false));
        testCases.add(new TestCase("aab", "c*a*b", true));
        testCases.add(new TestCase("a", "", false));
        testCases.add(new TestCase("a", "ab*", true));
        testCases.add(new TestCase("abcd", "d*", false));
        testCases.add(new TestCase("", "*", true));
        testCases.add(new TestCase("", ".*", true));
        testCases.add(new TestCase("bbbba", ".*a*a", true));
    }


    @Test
    public void solution1() throws Exception {
        for(TestCase testCase: testCases){
            Assert.assertEquals(testCase.result, RegularExpressionMatching.solution1(testCase.s, testCase.p));
        }
    }

}