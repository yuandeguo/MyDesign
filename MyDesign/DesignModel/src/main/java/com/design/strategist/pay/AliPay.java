package com.design.strategist.pay;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/1 23:28
 * @Description 支付宝支付
 */
public class AliPay implements Payment {
    @Override
    public boolean pay(Integer orderId, Integer amount) {
        System.out.printf("--%s--", "支付宝 支付");
        return true;
    }
}

