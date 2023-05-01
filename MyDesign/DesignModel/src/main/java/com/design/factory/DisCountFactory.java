package com.design.factory;

import com.design.strategist.count.CashReturnDiscount;
import com.design.strategist.count.Discount;
import com.design.strategist.count.NoDiscount;
import com.design.strategist.count.NormalDiscount;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 0:03
 * @Description 折扣的享元模式
 */
public class DisCountFactory {

    private static Map<String, Discount> discountMap = new ConcurrentHashMap<String, Discount>();
    public static Discount getDiscount(String key) throws Exception {

        if (DisCountFactory.discountMap.containsKey(key)) {

            return DisCountFactory.discountMap.get(key);
        }
        Discount discount=null;
        if("normal".equals(key))
        {
           discount=new NormalDiscount();

        }
        else if("no".equals(key))
        {
            discount=new NoDiscount();
        }
        else if("CashReturn".equals(key))
        {
            discount=new CashReturnDiscount();
        }
        else {
            Exception Exception=new RuntimeException("折扣传递错误");
            throw Exception;
        }
        DisCountFactory.discountMap.put(key, discount);
        return discount;
    }

}
