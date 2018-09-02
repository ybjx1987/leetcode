package com.ybjx.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YuBing on 2018/9/2.
 */
public class TestCase {
    private JSONObject jsonObject;
    private List<Object> parameter = new ArrayList<Object>();
    private Object result;
    private List<TestCaseResult> testCaseResults = new ArrayList<TestCaseResult>();

    public List<Object> getParameter() {
        return parameter;
    }

    public void setParameter(List<Object> parameter) {
        this.parameter = parameter;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public List<TestCaseResult> getTestCaseResults() {
        return testCaseResults;
    }

    public void setTestCaseResults(List<TestCaseResult> testCaseResults) {
        this.testCaseResults = testCaseResults;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
