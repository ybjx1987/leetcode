package com.ybjx.leetcode;

import com.alibaba.fastjson.JSONArray;

/**
 * Created by YuBing on 2018/9/3.
 */
public class RemoveNthNodeFromEndOfList extends BaseSolution {
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
        testCase.getParameter().add(testCase.getJsonObject().getJSONArray("parameter").getInteger(1));

        array = testCase.getJsonObject().getJSONArray("result");
        if(array.size() == 0){
            testCase.setResult(null);
            return testCase;
        }
        temp = new ListNode(array.getInteger(0));
        testCase.setResult(temp);
        for(int j = 1; j < array.size(); j++){
            temp.next = new ListNode(array.getInteger(j));
            temp = temp.next;
        }
        return testCase;
    }

    public static ListNode solution(ListNode node, int n){
        ListNode temp = null;
        ListNode current = node;

        while(current != null){
            if(temp != null){
                temp = temp.next;
            }
            if(n == 0) {
                temp = node;
            }
            n--;
            current = current.next;
        }
        if(temp != null){
            if(temp.next != null){
                temp.next = temp.next.next;
            }
        }
        else{
            return node.next;
        }
        return node;
    }
}
