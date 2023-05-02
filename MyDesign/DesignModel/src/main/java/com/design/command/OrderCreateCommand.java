package com.design.command;

import com.design.observe.Observer;
import com.design.observe.EmailObserver;
import com.design.observe.OrderSubject;
import com.design.observe.StockObserver;
import com.design.pojo.Order;
import com.design.responsibility.OrderHandler;
import com.design.responsibility.PayCheckHandler;
import com.design.responsibility.StockCheckHandler;
import com.design.service.OrderService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 11:23
 * @Description null
 */
@Component
public class OrderCreateCommand implements OrderCommand {

    @Resource
    private OrderService orderService;
    @Resource
    StockCheckHandler stockCheckHandler;

    @Resource
    OrderSubject orderSubject;
    public boolean execute(Order order) {
        if(stockCheckHandler.handle(order)){
            orderService.createOrder(order);
        }
        return true;
    }

    public void undo(Order order) {
        // 修改订单状态，触发通知所有观察者订单状态变更的事件
        orderSubject.notify(order);
        orderService.cancelOrder(order);
    }
}

