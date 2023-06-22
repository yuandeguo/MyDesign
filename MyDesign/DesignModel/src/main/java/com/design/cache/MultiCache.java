package com.design.cache;

import lombok.Data;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/6/22 15:41
 * @Description null
 */
@Data
public class MultiCache {

    private RedisDecorate redisDecorate;

    /**
     * 获取一级和二级缓存
     * @param key
     * @param t
     * @param <T>
     * @return
     */
    public <T> T getCacheEntity(String key, Class<T> t) {
        return redisDecorate.get(key, t);
    }
}
