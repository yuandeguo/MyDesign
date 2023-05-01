package com.design.service.impl;


import com.design.service.RedisService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/3/8 10:10
 * @Description null
 */
@Slf4j
@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public  <T> T get(String key, Class<T> clazz) {


        String data = stringRedisTemplate.opsForValue().get(key);
        if(!StringUtils.hasText(data)){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();

        T t = null;
        try {
            t = (T)  mapper.readValue(data,clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return t;

    }

    @Override
    public void set(String key, Object o) {
        ValueOperations valueOperations= stringRedisTemplate.opsForValue();
        ObjectMapper mapper = new ObjectMapper();
        //p是指定要转换的对象
        try {
            String json=mapper.writeValueAsString(o);
            valueOperations.set(key,json);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Boolean limitIp(String requestURI) {
        return true;
    }

    @Override
    public Object limit_listPush(String limit_list) {
        return "100";
    }


}
