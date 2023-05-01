package com.design.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/4/23 0:36
 * @Description null
 */
@Data
public class Cart implements Serializable {
    public static final Long serialVersionUID = 1L;
    private Integer id;
    private Integer userId;
    private Integer productId;
    //对应的数目
    private Integer num;
}
