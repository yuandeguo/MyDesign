package com.design.responsibility;

import com.design.pojo.Order;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/6/22 22:51
 * @Description null
 */
public class InventoryDeductionHandler extends OrderHandler {
    @Override
    public void handleOrder(Order order) {
        // 扣除库存的逻辑

        // 如果存在下一个处理器，则继续处理
        if (nextHandler != null) {
            nextHandler.handleOrder(order);
        }
    }
}
