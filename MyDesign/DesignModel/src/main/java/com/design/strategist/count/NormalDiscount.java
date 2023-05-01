package com.design.strategist.count;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/1 23:54
 * @Description null
 */
public class NormalDiscount implements Discount{

    @Override
    public Integer getMoney(Integer money) {
        Long round = Math.round(money * 0.8);
        return Integer.valueOf(round.toString());
    }
}
