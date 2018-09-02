package com.ybjx.leetcode;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by YuBing on 2018/9/2.
 */
public class AddTwoNumbers extends BaseSolution{
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

    /**
     * 普通遍历实现
     * 说明：时间复杂度O(n)
     */
    public static ListNode solution1(ListNode l1, ListNode l2){
        ListNode l3 = l1;
        ListNode l4 = l2;
        ListNode root;
        while (true){
            if(l4 == null){
                root = l1;
                l3 = l1;
                l4 = l2;
                break;
            }
            if(l3 == null){
                root = l2;
                l3 = l2;
                l4 = l1;
                break;
            }
            l3 = l3.next;
            l4 = l4.next;
        }
        while (true){
            if(l4 == null && l3 == null){
                break;
            }
            if(l4 != null){
                l3.val += l4.val;
            }
            if(l3.val > 9){
                l3.val -= 10;
                if(l3.next == null) {
                    l3.next = new ListNode(1);
                }
                else{
                    l3.next.val += 1;
                    if(l3.next.val < 10 && l4 == null){
                        break;
                    }
                }
            }
            else{
                if(l4 == null){
                    break;
                }
            }
            l3 = l3.next;
            if(l4 != null) {
                l4 = l4.next;
            }
        }
        return root;
    }

    /**
     * 循环遍历实现，会提前结束遍历
     * 说明：时间复杂度O(n)
     */
    public static ListNode solution2(ListNode l1, ListNode l2){
        ListNode root = l1;
        while (true){
            l1.val += l2.val;
            if(l1.next == null){
                l1.next = l2.next;
                break;
            }
            if(l2.next == null){
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        l1 = root;
        while (l1 != null){
            if(l1.val > 9){
                l1.val -= 10;
                if(l1.next == null){
                    l1.next = new ListNode(1);
                    break;
                }
                else{
                    l1.next.val += 1;
                }
            }
            l1 = l1.next;
        }
        return root;
    }
}
