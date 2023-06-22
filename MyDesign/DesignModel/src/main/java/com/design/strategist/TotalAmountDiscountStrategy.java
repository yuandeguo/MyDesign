package com.design.strategist;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/6/22 16:55
 * @Description 总额折扣策略
 */
class TotalAmountDiscountStrategy implements DiscountStrategy {
    private double discountRate;

    public TotalAmountDiscountStrategy(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double applyDiscount(double amount) {
        return amount * (1 - discountRate);
    }
}