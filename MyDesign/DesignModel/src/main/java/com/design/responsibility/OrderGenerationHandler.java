package com.design.responsibility;

import com.design.pojo.Order;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/6/22 22:52
 * @Description null
 */
public class OrderGenerationHandler extends OrderHandler {
    @Override
    public void handleOrder(Order order) {
        // 生成订单的逻辑
        if (order.getStatus()==1) {
            System.out.println("Order generated: " + order.getId());
        } else {
            System.out.println("Order generation failed: Invalid order");
        }
    }
}
