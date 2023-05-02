package com.design.command;

import com.design.pojo.Order;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 11:23
 * @Description null
 */
public interface OrderCommand {
    boolean execute(Order order);
    void undo(Order order);
}
