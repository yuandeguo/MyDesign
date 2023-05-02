package com.design.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

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
public class Order implements Serializable {
    public static final Long serialVersionUID = 1L;
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer productNum;
    private Integer  productPrice;
    private Integer payType;
    private String discount;
    private Long    orderTime;
}