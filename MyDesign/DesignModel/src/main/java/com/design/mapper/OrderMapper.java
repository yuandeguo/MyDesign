package com.design.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.design.pojo.Order;
import com.design.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/2 16:23
 * @Description null
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
