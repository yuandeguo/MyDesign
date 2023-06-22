package com.design.factory;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/6/22 16:07
 * @Description null
 */
public class PaymentFactory {
    public Payment createPayment(String paymentType) {
        switch (paymentType)
        {
            case "wechat":
                return new WeChatPayment();
            case "alipay":
                return new AliPayment();
            case "bank":
                return new BankPayment();
            default: throw new IllegalArgumentException("Invalid payment type: " + paymentType);
        }
    }
}
