package com.design.strategist;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/6/22 16:57
 * @Description 客户级别折扣策略
 */
class CustomerLevelDiscountStrategy implements DiscountStrategy {
    private double discountRate;

    public CustomerLevelDiscountStrategy(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double applyDiscount(double amount) {
        return amount * (1 - discountRate);
    }
}