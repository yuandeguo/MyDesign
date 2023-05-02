package com.design.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.design.mapper.CartMapper;
import com.design.mapper.ProductMapper;
import com.design.pojo.Cart;
import com.design.pojo.Product;
import com.design.service.CartService;
import com.design.service.ProductService;
import com.design.service.RedisService;

import javax.annotation.Resource;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 16:22
 * @Description null
 */
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private RedisService redisService;
}
