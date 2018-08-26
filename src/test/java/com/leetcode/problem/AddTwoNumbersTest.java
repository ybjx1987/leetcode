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
public class AddTwoNumbersTest {
    private AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

    class TestCase{
        AddTwoNumbers.ListNode listNode1;
        AddTwoNumbers.ListNode listNode2;
        AddTwoNumbers.ListNode result;
    }

    private List<TestCase> testCaseList = new ArrayList<TestCase>();

    @Before
    public void loadTestCase(){
        TestCase testCase = new TestCase();
        testCase.listNode1 = new AddTwoNumbers.ListNode(2);
        testCase.listNode1.next = new AddTwoNumbers.ListNode(4);
        testCase.listNode1.next.next = new AddTwoNumbers.ListNode(3);

        testCase.listNode2 = new AddTwoNumbers.ListNode(5);
        testCase.listNode2.next = new AddTwoNumbers.ListNode(6);
        testCase.listNode2.next.next = new AddTwoNumbers.ListNode(4);

        testCase.result = new AddTwoNumbers.ListNode(7);
        testCase.result.next = new AddTwoNumbers.ListNode(0);
        testCase.result.next.next = new AddTwoNumbers.ListNode(8);
        testCaseList.add(testCase);
    }

    @Test
    public void solution1() throws Exception {
        for(TestCase testCase: testCaseList){
            Assert.assertEquals(testCase.result, addTwoNumbers.solution1(testCase.listNode1, testCase.listNode2));
        }
    }

    @Test
    public void solution2() throws Exception {
        for(TestCase testCase: testCaseList){
            Assert.assertEquals(testCase.result, addTwoNumbers.solution2(testCase.listNode1, testCase.listNode2));
        }
    }

}