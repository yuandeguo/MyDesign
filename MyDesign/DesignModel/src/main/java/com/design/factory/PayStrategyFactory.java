package com.design.factory;
import com.design.strategist.pay.AliPay;
import com.design.strategist.pay.Payment;
import com.design.strategist.pay.UnionPay;
import com.design.strategist.pay.WeChatPay;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/1 23:31
 * @Description 支付策略工厂
 */
public class PayStrategyFactory {
    // 支付方式常量
    public static final String ALI_PAY = "1";
    public static final String WECHAT_PAY = "2";
    public static final String UNION_PAY = "3";

    private static Map<String, Payment> PAYMENT_STRATEGY_MAP = new HashMap<>();

    static {
        PAYMENT_STRATEGY_MAP.put(ALI_PAY, new AliPay());
        PAYMENT_STRATEGY_MAP.put(UNION_PAY, new UnionPay());
        PAYMENT_STRATEGY_MAP.put(WECHAT_PAY, new WeChatPay());
    }
    /**
     * 获取支付方式类
     * @param payType 前端传入支付方式
     * @return
     * Payment payment = PayStrategyFactory.getPayment(order.getPayType());
     * boolean pay = payment.pay(order.getOrderId(), order.getAmount());
     * return pay;
     *
     *
     */
    public static Payment getPayment(String payType) {
        Payment payment = PAYMENT_STRATEGY_MAP.get(payType);
        if (payment == null) {
            throw new NullPointerException("支付方式选择错误");
        }
        return payment;
    }
}

