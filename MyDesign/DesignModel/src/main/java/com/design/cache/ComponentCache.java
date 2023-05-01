package com.design.cache;

import org.aspectj.lang.ProceedingJoinPoint;

public interface ComponentCache {
    <T> T get(String key, Class<T> T);
}
