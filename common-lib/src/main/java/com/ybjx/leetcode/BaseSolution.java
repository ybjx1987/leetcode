package com.ybjx.leetcode;

import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YuBing on 2018/9/2.
 */
public class BaseSolution {
    private static List<Method> methods = new ArrayList<Method>();
    private static void run(){
        TestCaseLoader.loadTestCase();
        List<String> list = getClassNameByFile(BaseSolution.class.getClassLoader().getResource("com/ybjx/leetcode").getPath());
        loadMethod(list);
        for(int i = 0; i < TestCaseLoader.getTestCaseArray().size(); i++){
            TestCase testCase = new TestCase();
            testCase.setJsonObject(TestCaseLoader.getTestCaseArray().getJSONObject(i));
            TestCaseLoader.getTestCases().add(testCase);
            runOne(testCase);
        }
        printResult();
    }

    private static void printResult(){
        StringBuilder builder = new StringBuilder();
        StringBuilder temp = new StringBuilder("|  NO.  ");
        StringBuilder line = new StringBuilder("+-------");
        for(Method method: methods){
            temp.append("|  ");
            temp.append(method.getName());
            temp.append("  ");
            line.append("|--");
            for(int i = 0; i < method.getName().length(); i++){
                line.append("-");
            }
            line.append("--");
        }
        line.append("+\n");
        builder.append(line);
        builder.append(temp).append("|\n");
        for(int i = 0; i < TestCaseLoader.getTestCases().size(); i++){
            builder.append(line);
            builder.append("| ");
            builder.append(i+1);
            for(int j = 0; j < ((i > 8)?4:5); j ++){
                builder.append(" ");
            }
            for(int j = 0; j < TestCaseLoader.getTestCases().get(i).getTestCaseResults().size(); j++){
                builder.append("| ");
                TestCaseResult result = TestCaseLoader.getTestCases().get(i).getTestCaseResults().get(j);
                if(result.isSuccess()){
                    String str = "T(" + result.getTime();
                    builder.append(str);
                    builder.append(")");
                    for(int k = 0; k < result.getName().length() + 2 - str.length(); k ++){
                        builder.append(" ");
                    }
                }
                else{
                    builder.append("****");
                    for (int k = 0; k < result.getName().length() - 1; k++){
                        builder.append(" ");
                    }
                }

            }
            builder.append("|\n");
        }
        builder.append(line);

        System.out.printf(builder.toString());
    }

    private static void runOne(TestCase testCase){
        for(Method method: methods){
            reset(testCase);
            TestCaseResult testCaseResult = new TestCaseResult();
            testCase.getTestCaseResults().add(testCaseResult);
            testCaseResult.setName(method.getName());
            try{
                Object [] param = new Object[method.getParameterTypes().length];
                Class [] cl = method.getParameterTypes();
                for(int i = 0; i < cl.length; i++){
                    param[i] = update(testCase.getParameter().get(i), cl[i].getName());
                }
                long start = System.currentTimeMillis();
                Object object = method.invoke(null, param);
                testCaseResult.setTime(System.currentTimeMillis() - start);
                Object result = update(testCase.getResult(), method.getReturnType().getName());
                String name = method.getReturnType().getName();
                if(name.equals("[I")){
                    Assert.assertArrayEquals((int[]) object, (int[]) result);
                } else if(name.equals("[J")){
                    Assert.assertArrayEquals((long[]) object, (long[]) result);
                }
                else {
                    Assert.assertEquals(object, result);
                }
                testCaseResult.setSuccess(true);
            }
            catch (Throwable ignore){
                testCaseResult.setSuccess(false);
            }
        }
    }

    private static Object update(Object object, String name){
        if(object instanceof List){
            List list = (List)object;
            if(name.equals("[Ljava.lang.Integer;") || name.equals("[I")){
                int [] result = new int[list.size()];
                for(int i = 0; i < list.size(); i++){
                    result[i] = (Integer) list.get(i);
                }
                return result;
            } else if(name.equals("[Ljava.lang.Long;") || name.equals("[J")){
                long [] result = new long[list.size()];
                for(int i = 0; i < list.size(); i++){
                    result[i] = (Long) list.get(i);
                }
                return result;
            } else if(name.equals("[Ljava.lang.Float;") || name.equals("[F")){
                float [] result = new float[list.size()];
                for(int i = 0; i < list.size(); i++){
                    result[i] = (Float) list.get(i);
                }
                return result;
            } else if(name.equals("[Ljava.lang.Double;") || name.equals("[D")){
                double [] result = new double[list.size()];
                for(int i = 0; i < list.size(); i++){
                    result[i] = (Double) list.get(i);
                }
                return result;
            } else if(name.equals("[Ljava.lang.String;")){
                String [] result = new String[list.size()];
                for(int i = 0; i < list.size(); i++){
                    result[i] = (String) list.get(i);
                }
                return result;
            }
        }
        return object;
    }

    private static void loadMethod(List<String> list){
        for(String str: list){
            try{
                Class c = BaseSolution.class.getClassLoader().loadClass(str);
                Method []  methodList = c.getMethods();
                for(Method method: methodList){
                    if(method.getName().startsWith("solution")){
                        methods.add(method);
                    }
                }
            }
            catch (Exception ignore){
            }
        }
    }

    private static List<String> getClassNameByFile(String filePath){
        List<String> myClassName = new ArrayList<String>();
        File file = new File(filePath);
        File[] childFiles = file.listFiles();
        if (childFiles == null)
            return myClassName;
        for (File childFile : childFiles) {
            if (childFile.isDirectory()) {
                myClassName.addAll(getClassNameByFile(childFile.getPath()));
            } else {
                String childFilePath = childFile.getPath();
                if (childFilePath.endsWith(".class")) {
                    childFilePath = childFilePath.replaceAll("\\\\", "/");
                    childFilePath = childFilePath.substring(childFilePath.indexOf("/classes/") + 9, childFilePath.lastIndexOf("."));
                    childFilePath = childFilePath.replace("/", ".");
                    myClassName.add(childFilePath);
                }
            }
        }
        return myClassName;
    }

    private static void reset(TestCase testCase){
        testCase.getParameter().clear();
        List<String> list = getClassNameByFile(BaseSolution.class.getClassLoader().getResource("com/ybjx/leetcode").getPath());
        for(String s: list){
            try{
                Class c = BaseSolution.class.getClassLoader().loadClass(s);
                Method method = c.getMethod("loadTestCase", TestCase.class);
                Object object = method.invoke(null, testCase);
                if(object != null && object instanceof TestCase){
                    return;
                }
            }
            catch (Exception ignore){
            }
        }
        TestCaseLoader.reset(testCase);
    }

    public static void main(String [] args) throws IOException {
        run();
    }
}
