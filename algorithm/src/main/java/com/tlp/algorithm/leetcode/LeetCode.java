package com.tlp.algorithm.leetcode;

import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @className: LeetCode
 * @description:
 * @author: tianlingpeng
 * @create: 2019-09-19 14:22
 */
public class LeetCode {
    public static void main(String[] args) {
        LeetCode leetCode = new LeetCode();

//        int[] nums = { 2, 7, 11, 15 };
//        int[] arr = twoSum(nums, 26);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode = leetCode.addTwoNumbers(listNode1, listNode1);

        while (listNode != null) {
            int i = listNode.val;
            System.out.println(i);
            listNode = listNode.next;
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = i + 1; k < nums.length; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> list1 = new ArrayList<>();
                        list1.add(nums[i]);
                        list1.add(nums[j]);
                        list1.add(nums[k]);
                        list.add(list1);
                    }
                }
            }
        }
        return list;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return head.next;
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int left = 0;
        for (int i = 0; i < n; i++) {
            for (int j =left; j <n ; ) {
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                    left= ++j;
                    max =Math.max(max,j-i);
                }else {
                    set.remove(s.charAt(i));
                    break;
                }
            }
        }
        return max;
    }
}

class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
