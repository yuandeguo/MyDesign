package com.design.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.design.factory.DisCountFactory;
import com.design.factory.PayStrategyFactory;
import com.design.mapper.CartMapper;
import com.design.mapper.OrderMapper;
import com.design.pojo.Cart;
import com.design.pojo.Order;
import com.design.service.CartService;
import com.design.service.OrderService;
import com.design.service.RedisService;
import com.design.strategist.count.Discount;
import com.design.strategist.pay.Payment;
import org.aspectj.weaver.ast.Or;

import javax.annotation.Resource;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 11:24
 * @Description null
 */
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private RedisService redisService;

    @Override
    public void createOrder(Order order) {
        try {
            Discount discount = DisCountFactory.getDiscount(order.getDiscount());
            Integer money = discount.getMoney(order.getProductPrice());
            Payment payment = PayStrategyFactory.getPayment(order.getPayType().toString());
            payment.pay(order.getId(),money);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cancelOrder(Order order) {

    }
}
