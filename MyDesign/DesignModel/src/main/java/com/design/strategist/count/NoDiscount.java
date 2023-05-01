package com.design.strategist.count;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/1 23:55
 * @Description null
 */
public class NoDiscount implements Discount{
    @Override
    public Integer getMoney(Integer money) {
        return money;
    }
}
