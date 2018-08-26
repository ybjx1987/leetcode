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
 * Created by YuBing on 2018/8/26.
 */
public class LongestPalindromeTest {
    private LongestPalindrome longestPalindrome = new LongestPalindrome();

    private Map<String, List<String>> testCase = new HashMap<String, List<String>>();

    @Before
    public void loadTestCase(){
        List<String> list = new ArrayList<String>();
        list.add("bab");
        list.add("aba");
        testCase.put("babad", list);
        list = new ArrayList<String>();
        list.add("bb");
        testCase.put("cbbd", list);
        list = new ArrayList<String>();
        list.add("b");
        testCase.put("b", list);
        list = new ArrayList<String>();
        list.add("bb");
        testCase.put("bb", list);
        list = new ArrayList<String>();
        list.add("cdbbdc");
        testCase.put("abcdbbdcdd", list);
        list = new ArrayList<String>();
        list.add("bb");
        testCase.put("abb", list);
    }

    @Test
    public void solution1() throws Exception {
        for(Map.Entry<String, List<String>> entry: testCase.entrySet()){
            Assert.assertEquals(entry.getValue().contains(longestPalindrome.solution1(entry.getKey())), true);
        }
    }
}