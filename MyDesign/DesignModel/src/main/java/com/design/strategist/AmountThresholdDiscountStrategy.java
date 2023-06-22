package com.design.strategist;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/6/22 16:56
 * @Description 满减策略
 */
class AmountThresholdDiscountStrategy implements DiscountStrategy {
    private double threshold;
    private double discountAmount;

    public AmountThresholdDiscountStrategy(double threshold, double discountAmount) {
        this.threshold = threshold;
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double amount) {
        if (amount >= threshold) {
            return amount - discountAmount;
        }
        return amount;
    }
}