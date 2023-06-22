package com.design.observe;

import com.design.pojo.Order;
import com.design.utiles.R;


/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 0:36
 * @Description 主题接口
 */
public  interface Subject {
    //订阅
    void registerObserver(Observer observer);

    //取消订阅
    void removeObserver(Observer observer);
    //通知
    void notifyObservers(Integer status);
}
