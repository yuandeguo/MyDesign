package com.design.Config;

import com.design.observe.EmailObserver;
import com.design.observe.Observer;
import com.design.observe.OrderSubject;
import com.design.observe.StockObserver;
import com.design.responsibility.OrderHandler;
import com.design.responsibility.PayCheckHandler;
import com.design.responsibility.StockCheckHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 16:10
 * @Description null
 */
@Configuration
public class MyConfig {
        @Bean
        public  OrderHandler getOrderHandler(){
            OrderHandler stockCheckHandler = new StockCheckHandler();
            OrderHandler payCheckHandler = new PayCheckHandler();
            stockCheckHandler.setSuccessor(payCheckHandler);
            return stockCheckHandler;
        }
        @Bean
        public OrderSubject getOrderSubject(){
            // 创建主题对象
            OrderSubject subject = new OrderSubject();
            // 创建观察者对象，并将它们注册到主题对象中
            Observer emailObserver = new EmailObserver();
            Observer stockObserver = new StockObserver();
            subject.subscribe(emailObserver);
            subject.subscribe(stockObserver);
            return subject;
        }

}
