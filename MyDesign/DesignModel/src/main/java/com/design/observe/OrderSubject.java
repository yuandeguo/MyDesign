package com.design.observe;

import com.design.utiles.R;

import java.util.ArrayList;
import java.util.List;


/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 0:37
 * @Description 订单观察者
 */
public class OrderSubject<E> extends Subject<E> {
    private List<Observer<E> > observers = new ArrayList<>();
    @Override
    R subscribe(Observer<E>  observer) {
        if (this.observers.contains(observer))
            return R.success("已经订阅过了");
        this.observers.add(observer);
        return R.success("订阅成功");
    }

    @Override
    R unsubscribe(Observer<E>  orderObserver) {
        this.observers.remove(orderObserver);
        return R.success("订阅取消成功");
    }

    @Override
    void notify(E event) {
        observers.forEach(observer -> {
            observer.handEvent(event);
        });
    }
}
