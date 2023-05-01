package com.design.observe;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 0:41
 * @Description null
 */

import com.design.singleTon.ThreadPool;

/**
 * 订单观察者
 * @param <E>
 */
public class OrderObserver<E> extends Observer<E> {
    @Override
    void handEvent(E event){
        ThreadPool.getThreadPool().executor(new Runnable() {
            @Override
            public void run() {
                saveOrder(event);
            }
        });
    }

    void saveOrder(E message){
        System.out.println("取消订单");
    }
}
