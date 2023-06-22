package com.design.command;

import com.design.pojo.Order;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/6/22 16:16
 * @Description null
 */
public class CancelOrderCommand implements Command {
    private Order order;

    public CancelOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.setStatus(1);
        System.out.println("Order cancelled.");
    }

    @Override
    public void undo() {
        order.setStatus(0);
        System.out.println("Order cancellation undone.");
    }
}
