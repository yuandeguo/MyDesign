package com.design.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.design.mapper.OrderMapper;
import com.design.pojo.Order;
import com.design.service.OrderService;
import com.design.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

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
    @Autowired
    private TransactionTemplate transactionTemplate;
    @Override
    public void createOrder(Order order) {
        Boolean status = transactionTemplate.execute((t) -> {
            Object savepoint = t.createSavepoint();
            try {
                return true;
            }
            catch (Exception e){
                t.rollbackToSavepoint(savepoint);
                e.printStackTrace();
                return false;
            }
        });


    }

    @Override
    public void cancelOrder(Order order) {



    }
}
