package com.design.responsibility;

import com.design.pojo.Order;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 11:14
 * @Description null
 */
public class StockCheckHandler extends OrderHandler {
    public boolean handle(Order order) {
        if (checkStock(order)) {
            System.out.println("库存充足，订单已通过库存检查。");
            if (successor != null) {
           return     successor.handle(order);
            }
        } else {
            System.out.println("库存不足，订单未通过库存检查。");
        }
        return false;
    }

    private boolean checkStock(Order order) {
        // 实现库存检查逻辑
        return true;
    }
}
