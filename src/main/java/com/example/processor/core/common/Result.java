package com.example.processor.core.common;

import java.util.HashMap;
import java.util.Map;

public class Result {


    public static Map<String,Object> success(){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",1);
        resultMap.put("msg","操作成功!");
        return resultMap;
    }

    public static Map<String,Object> success(Object obj){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",1);
        resultMap.put("msg","操作成功!");
        resultMap.put("result",obj);
        return resultMap;
    }


    public static Map<String,Object> error(String msg){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        resultMap.put("msg",msg);
        return resultMap;
    }





}
