package com.design.strategist.pay;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/1 23:29
 * @Description 微信 支付
 */
public class WeChatPay implements Payment {
    @Override
    public boolean pay(String orderId, Long amount) {
        System.out.printf("--%s--", "微信 支付");
        return true;
    }
}