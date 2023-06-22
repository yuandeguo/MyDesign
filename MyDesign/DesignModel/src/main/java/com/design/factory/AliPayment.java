package com.design.factory;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/6/22 16:06
 * @Description null
 */
public class AliPayment implements Payment{
    @Override
    public void pay(int amount) {
        System.out.println("Using AliPay. Amount: " + amount);
        // 实现支付宝支付的逻辑
    }
}
