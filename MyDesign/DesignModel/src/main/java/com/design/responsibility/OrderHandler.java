package com.design.responsibility;

import com.design.pojo.Order;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 11:12
 * @Description null
 */
public abstract class OrderHandler {
    protected OrderHandler successor;

    public void setSuccessor(OrderHandler successor) {
        this.successor = successor;
    }
    public abstract boolean handle(Order order);
}
