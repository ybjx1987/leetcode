package com.leetcode.problem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YuBing on 2018/9/1.
 */
public class ContainerWithMostWaterTest {

    class TestCase{
        int [] value;
        int result;

        public TestCase(int [] value, int result){
            this.value = value;
            this.result = result;
        }
    }

    List<TestCase> testCases = new ArrayList<TestCase>();

    @Before
    public void loadTestCase(){
        testCases.add(new TestCase(new int[]{1,8,6,2,5,4,8,3,7}, 49));
        testCases.add(new TestCase(new int[]{0, 2}, 0));
    }

    @Test
    public void solution1() throws Exception {
        for(TestCase testCase: testCases){
            Assert.assertEquals((long)testCase.result, ContainerWithMostWater.solution1(testCase.value));
        }
    }

    @Test
    public void solution2() throws Exception {
        for(TestCase testCase: testCases){
            Assert.assertEquals((long)testCase.result, ContainerWithMostWater.solution2(testCase.value));
        }
    }

    @Test
    public void solution3() throws Exception {
        for(TestCase testCase: testCases){
            Assert.assertEquals((long)testCase.result, ContainerWithMostWater.solution3(testCase.value));
        }
    }

}