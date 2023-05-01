package com.design.service;


import com.sun.org.apache.xpath.internal.operations.Bool;

public interface RedisService {
      <T> T get(String key, Class<T> clazz);
    void set(String key, Object o);


    Boolean limitIp(String requestURI);

    Object limit_listPush(String limit_list);
}
