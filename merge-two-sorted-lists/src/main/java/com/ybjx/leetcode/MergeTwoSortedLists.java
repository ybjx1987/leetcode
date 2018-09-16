package com.ybjx.leetcode;

import com.alibaba.fastjson.JSONArray;

/**
 * Created by YuBing on 2018/9/12.
 */
public class MergeTwoSortedLists extends BaseSolution{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof ListNode)) {
                return false;
            }
            ListNode l = (ListNode) obj;
            return this.val == l.val && (this.next == null && l.next == null || this.next != null && l.next != null && this.next.equals(l.next));
        }
    }

    public static TestCase loadTestCase(TestCase testCase){
        JSONArray array = testCase.getJsonObject().getJSONArray("parameter").getJSONArray(0);
        ListNode temp = new ListNode(array.getInteger(0));
        testCase.getParameter().add(temp);
        for(int j = 1; j < array.size(); j++){
            temp.next = new ListNode(array.getInteger(j));
            temp = temp.next;
        }
        array = testCase.getJsonObject().getJSONArray("parameter").getJSONArray(1);
        temp = new ListNode(array.getInteger(0));
        testCase.getParameter().add(temp);
        for(int j = 1; j < array.size(); j++){
            temp.next = new ListNode(array.getInteger(j));
            temp = temp.next;
        }

        array = testCase.getJsonObject().getJSONArray("result");
        temp = new ListNode(array.getInteger(0));
        testCase.setResult(temp);
        for(int j = 1; j < array.size(); j++){
            temp.next = new ListNode(array.getInteger(j));
            temp = temp.next;
        }
        return testCase;
    }

    public static ListNode solution1(ListNode l1, ListNode l2){
        ListNode root = null, p = null;
        if(l1 == null && l2 == null){
            return null;
        }
        else if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        while(l1 != null && l2 != null){
            if(root == null){
                root = new ListNode(l1.val > l2.val ? l2.val : l1.val);
                p = root;
            }
            else{
                p.next = new ListNode(l1.val > l2.val ? l2.val : l1.val);
                p = p.next;
            }
            if(l1.val > l2.val){
                l2 = l2.next;
            }
            else{
                l1 = l1.next;
            }
        }
        if(l1 != null){
            p.next = l1;
        }
        if(l2 != null){
            p.next = l2;
        }
        return root;
    }
}
