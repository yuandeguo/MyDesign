package com.design.observe;

import com.design.observe.manager.InventoryManager;
import com.design.observe.manager.StoreManager;
import com.design.pojo.Order;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/6/22 22:44
 * @Description null
 */
public class demo {
    public static void main(String[] args) {
        // 创建订单对象
        Order order = new Order();

        // 创建观察者对象
        Observer inventoryManager = new InventoryManager();
        Observer storeManager = new StoreManager();

        // 注册观察者
        order.registerObserver(inventoryManager);
        order.registerObserver(storeManager);

        // 更新订单状态，并触发通知
        order.setStatus(0);
    }
}
