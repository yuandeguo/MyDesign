package com.design.strategist.count;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/1 23:54
 * @Description null
 */
public class CashReturnDiscount implements Discount{
    Integer returnMoney=10;
    @Override
    public Integer getMoney(Integer money) {
        if(money>100)
            return money-10;
        else if(money>10)
            return money-5;
        return money;
    }
}
