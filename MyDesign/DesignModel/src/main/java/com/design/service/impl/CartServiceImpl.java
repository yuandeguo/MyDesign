package com.design.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.design.mapper.CartMapper;
import com.design.mapper.UserMapper;
import com.design.pojo.Cart;
import com.design.pojo.User;
import com.design.service.CartService;
import com.design.service.RedisService;
import com.design.service.UserService;

import javax.annotation.Resource;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 16:21
 * @Description null
 */
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
    @Resource
    private CartMapper cartMapper;
    @Resource
    private RedisService redisService;

}
