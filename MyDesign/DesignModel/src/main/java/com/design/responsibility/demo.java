package com.design.responsibility;

import com.design.pojo.Order;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/6/22 22:53
 * @Description null
 */
public class demo {
    public static void main(String[] args) {
        // 创建处理器对象
        OrderHandler orderInfoValidationHandler = new OrderInfoValidationHandler();
        OrderHandler inventoryDeductionHandler = new InventoryDeductionHandler();
        OrderHandler priceCalculationHandler = new PriceCalculationHandler();
        OrderHandler orderGenerationHandler = new OrderGenerationHandler();

        // 设置处理器链
        orderInfoValidationHandler.setNextHandler(inventoryDeductionHandler);
        inventoryDeductionHandler.setNextHandler(priceCalculationHandler);
        priceCalculationHandler.setNextHandler(orderGenerationHandler);

        // 创建订单对象
        Order order = new Order();

        // 处理订单
        orderInfoValidationHandler.handleOrder(order);
    }
}
