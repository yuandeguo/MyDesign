package com.design.observe;

import com.design.pojo.Order;
import com.design.utiles.R;

import java.util.ArrayList;
import java.util.List;


/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 0:37
 * @Description 订单观察者
 */
public class OrderSubject implements Subject {
    private List<Observer > observers = new ArrayList<>();

    public R subscribe(Observer observer) {
        if (this.observers.contains(observer))
            return R.success("已经订阅过了");
        this.observers.add(observer);
        return R.success("订阅成功");
    }


    public R unsubscribe(Observer  orderObserver) {
        this.observers.remove(orderObserver);
        return R.success("订阅取消成功");
    }


    public void notify(Order event) {
        observers.forEach(observer -> {
            observer.handEvent(event);
        });
    }
}
