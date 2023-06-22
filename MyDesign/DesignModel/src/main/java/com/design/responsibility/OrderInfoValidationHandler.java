package com.design.responsibility;

import com.design.pojo.Order;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/6/22 22:50
 * @Description 验证订单信息处理器
 */
public class OrderInfoValidationHandler  extends OrderHandler {
    @Override
    public void handleOrder(Order order) {
        // 验证订单信息的逻辑
        if (order.getUserId() == null || order.getUserId()==0) {
            order.setStatus(0);
            System.out.println("Invalid order: missing customer name");
        }

        // 如果存在下一个处理器，则继续处理
        if (nextHandler != null) {
            nextHandler.handleOrder(order);
        }
    }
}
