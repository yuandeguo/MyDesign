package com.design.factory;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/6/22 16:05
 * @Description null
 */
public class WeChatPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Using WeChat Payment. Amount: " + amount);
        // 实现微信支付的逻辑
    }
}
