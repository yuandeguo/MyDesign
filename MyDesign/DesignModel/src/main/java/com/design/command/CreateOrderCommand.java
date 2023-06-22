package com.design.command;

import com.design.pojo.Order;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 11:23
 * @Description null
 */
public class CreateOrderCommand implements Command {


    private Order order;

    public CreateOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.setStatus(1);
        System.out.println("Order created.");
    }

    @Override
    public void undo() {
        order.setStatus(0);
        System.out.println("Order creation undone.");
    }
}

