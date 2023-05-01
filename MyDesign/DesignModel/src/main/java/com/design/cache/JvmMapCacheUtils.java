package com.design.cache;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 0:21
 * @Description 一级缓存
 */
public class JvmMapCacheUtils implements ComponentCache{
    private static Map<String, String> cacheMap = new ConcurrentHashMap<String, String>();
    /**
     * 添加缓存
     * @param key
     * @param object
     */
    public static void set(String key, Object object) {
        cacheMap.put(key, JSONObject.toJSONString(object));
    }

    /**
     * 获取缓存
     * @param key
     * @param t
     * @param <T>
     * @return
     */
    public  <T> T get(String key, Class<T> t) {
        String json = cacheMap.get(key);
        return JSONObject.parseObject(json, t);
    }

}
