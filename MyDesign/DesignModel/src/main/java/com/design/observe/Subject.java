package com.design.observe;

import com.design.utiles.R;


/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 0:36
 * @Description null
 */
public abstract class Subject<E> {
    //订阅
    abstract R subscribe(Observer<E> orderObserver);
    //取消订阅
    abstract R unsubscribe(Observer<E>  orderObserver);
    //通知
    abstract void notify(E event);
}
