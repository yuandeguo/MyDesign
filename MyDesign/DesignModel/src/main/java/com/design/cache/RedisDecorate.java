package com.design.cache;

import com.design.service.RedisService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 0:29
 * @Description 装饰器模式实现缓存
 */
public class RedisDecorate  extends JvmMapCacheUtils implements AbstractDecorate{
    @Autowired
    private RedisService redisService;


    @Override
    public <T> T get(String key, Class<T> t) {
        // 先查询二级缓存
        T redisUser = redisService.get(key, t);
        if (redisUser != null) {
            return (T) redisUser;
        }
        // 如果一级缓存存在数据
        T jvmUser = super.get(key, t);
        if (jvmUser == null) {
            return null;
        }
        // 将该缓存数据放入到二级缓存中
        redisService.set(key, jvmUser);
        return (T) jvmUser;
    }


}
