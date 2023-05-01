package com.design.observe;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 0:39
 * @Description 观察者处理 方法
 */
public abstract class Observer<E> {
    abstract void handEvent(E event);
}