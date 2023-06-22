package com.design.observe.manager;

import com.design.observe.Observer;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/6/22 22:43
 * @Description null
 */
public class InventoryManager implements Observer {
    @Override
    public void update(Integer status) {
        System.out.println("Inventory Manager received notification. Order status: " + status);
        // 执行库存管理员相关操作
    }
}
