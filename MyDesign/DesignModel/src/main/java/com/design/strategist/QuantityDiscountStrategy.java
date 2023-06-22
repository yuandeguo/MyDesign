package com.design.strategist;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/6/22 16:56
 * @Description 根据件数折扣策略
 */
class QuantityDiscountStrategy implements DiscountStrategy {
    private double discountRate;

    public QuantityDiscountStrategy(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double applyDiscount(double amount) {
        return amount * (1 - discountRate);
    }
}