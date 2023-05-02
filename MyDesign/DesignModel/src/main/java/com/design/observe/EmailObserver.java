package com.design.observe;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 0:41
 * @Description 取消订单
 */

import com.design.pojo.Order;
import com.design.singleTon.ThreadPool;

public class EmailObserver implements Observer{
    @Override
    public void handEvent(Order event){
        ThreadPool.getThreadPool().executor(new Runnable() {
            @Override
            public void run() {
                sendEmail(event);
            }
        });
    }

    public void sendEmail(Order message){
        System.out.println("发送邮件");
    }
}
