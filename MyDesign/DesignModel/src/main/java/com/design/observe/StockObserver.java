package com.design.observe;

import com.design.singleTon.ThreadPool;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 0:41
 * @Description 库存观察者
 */
public class StockObserver<E> extends Observer<E> {
    @Override
    void handEvent(E event) {
        ThreadPool.getThreadPool().executor(new Runnable() {
            @Override
            public void run() {
                deductInventory(event);
            }
        });
    }

    private void deductInventory(E o){
        System.out.println("恢复库存");
    }
}

