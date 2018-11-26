package com.ws.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 向页面返回数据格式信息
 */
public class MsgUtils {
    public static Map<String ,Object> getRight(Object obj){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",0);
        map.put("message","ok");
        map.put("data",obj);
        return map;
    }
    public static Map<String ,Object> getError(Object obj){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",1);
        map.put("message","no");
        map.put("data",obj);
        return map;
    }
}
