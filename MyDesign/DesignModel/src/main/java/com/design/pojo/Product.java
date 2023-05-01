package com.design.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/4/23 0:37
 * @Description null
 */
@Data
public class Product implements Serializable {

    public static final Long serialVersionUID = 1L;
    private Integer id;
    private String productName;
    /**
     * 商品价格
     */
    private Double productPrice;

    /**
     * 商品库存
     */
    private int productNum;

    /**
     * 已卖数量
     */
    private int productSales;


}
