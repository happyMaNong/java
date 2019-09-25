package com.tlp.algorithm;

import com.tlp.algorithm.leetcode.LeetCode;
import org.junit.Before;
import org.junit.Test;

/**
 * @className: TestCode
 * @description:
 * @author: tianlingpeng
 * @create: 2019-09-21 14:59
 */


public class TestCode {
    private LeetCode leetCode = null;

    @Before
    public void init() {
        leetCode = new LeetCode();
    }

    @Test
    public void lengthOfLongestSubstring() {
        int pwwkew = leetCode.lengthOfLongestSubstring("pwwkewr");
        System.out.println(pwwkew);
    }
}
