package com.design.pojo;

import com.design.observe.Observer;
import com.design.observe.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/4/23 0:36
 * @Description null
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order implements Serializable , Subject {
    public static final Long serialVersionUID = 1L;
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer productNum;
    private Integer  productPrice;
    private Integer payType;
    private String discount;
    private Long    orderTime;
    /**
     * 1有效 0失效
     */
    private Integer status;
    private List<Observer> observers;

    public void setStatus(Integer status) {
        this.status = status;
        notifyObservers(status);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Integer status) {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }


}