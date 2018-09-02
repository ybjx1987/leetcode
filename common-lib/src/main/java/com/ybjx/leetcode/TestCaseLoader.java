package com.ybjx.leetcode;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YuBing on 2018/9/2.
 */
public class TestCaseLoader {
    private static List<TestCase> testCases = new ArrayList<TestCase>();

    private static JSONArray testCaseArray;

    public static void loadTestCase(){
        InputStream  inputStream = TestCaseLoader.class.getResourceAsStream("/test-case.json");
        if(inputStream == null){
            return;
        }
        try {
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            String str = new String(data, "UTF-8");
            testCaseArray = JSONObject.parseArray(str);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static Object update(Object object){
        if(object instanceof JSONArray){
            List<Object> list = new ArrayList<Object>();
            JSONArray array = (JSONArray)object;
            for(int i = 0; i < array.size(); i++){
                list.add(update(array.get(i)));
            }
            return list;
        }
        else if(object instanceof BigDecimal){
            return ((BigDecimal)object).doubleValue();
        }
        else {
            return object;
        }
    }

    public static void reset(TestCase testCase){
        testCase.setParameter((List<Object>)update(testCase.getJsonObject().get("parameter")));
        testCase.setResult(update(testCase.getJsonObject().get("result")));
    }

    public static List<TestCase> getTestCases() {
        return testCases;
    }

    public static JSONArray getTestCaseArray() {
        return testCaseArray;
    }
}
