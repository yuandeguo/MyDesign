package com.design.responsibility;

import com.design.factory.PayStrategyFactory;
import com.design.pojo.Order;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 11:15
 * @Description null
 */
public class PayCheckHandler extends OrderHandler {
    public boolean handle(Order order) {
        if (checkPay(order)) {
            System.out.println("支付成功，订单已通过支付。");
            if (successor != null) {
             return   successor.handle(order);
            }
        } else {
            System.out.println("支付失败，订单未支付。");
        }
        return false;
    }

    private boolean checkPay(Order order) {
        PayStrategyFactory.getPayment(order.getPayType().toString());
        return true;
    }
}
