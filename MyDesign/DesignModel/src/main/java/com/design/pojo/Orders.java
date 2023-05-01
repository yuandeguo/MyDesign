package com.design.pojo;

import java.io.Serializable;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/4/23 0:36
 * @Description null
 */
public class Orders implements Serializable {
    public static final Long serialVersionUID = 1L;
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer productNum;
    private Double  productPrice;
    private Long    orderTime;
}