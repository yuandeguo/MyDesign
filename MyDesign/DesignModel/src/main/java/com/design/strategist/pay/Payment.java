package com.design.strategist.pay;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/1 23:28
 * @Description null
 */
public interface Payment {
    boolean pay(String orderId, Long amount);
}
