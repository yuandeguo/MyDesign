package com.design.observe;

import com.design.pojo.Order;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 0:39
 * @Description 观察者接口
 */
public  interface Observer {
     void handEvent(Order event);
}