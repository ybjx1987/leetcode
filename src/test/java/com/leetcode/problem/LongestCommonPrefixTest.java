package com.leetcode.problem;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YuBing on 2018/9/1.
 */
public class LongestCommonPrefixTest {
    @Test
    public void solution() throws Exception {
        Assert.assertEquals(LongestCommonPrefix.solution(new String[]{"flower","flow","flight"}), "fl");
        Assert.assertEquals(LongestCommonPrefix.solution(new String[]{"dog","racecar","car"}), "");
    }

}