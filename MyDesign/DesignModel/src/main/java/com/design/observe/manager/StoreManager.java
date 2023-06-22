package com.design.observe.manager;

import com.design.observe.Observer;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/6/22 22:44
 * @Description null
 */
public class StoreManager implements Observer {
    @Override
    public void update(Integer status) {
        System.out.println("Store Manager received notification. Order status: " + status);
        // 执行商场管理人员相关操作
    }
}
