package com.design.strategist.pay;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/1 23:29
 * @Description 银联 支付
 */
public class UnionPay implements Payment {
    @Override
    public boolean pay(Integer orderId, Integer amount) {
        System.out.printf("--%s--", "银联 支付");
        return true;
    }
}

