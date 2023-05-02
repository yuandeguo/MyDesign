package com.design.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.design.pojo.Order;
import com.design.pojo.User;
import org.aspectj.weaver.ast.Or;

public interface OrderService extends IService<Order> {
    void createOrder(Order order);

    void cancelOrder(Order order);
}
