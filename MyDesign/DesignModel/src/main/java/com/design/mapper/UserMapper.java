package com.design.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.design.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/4/23 15:43
 * @Description null
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User selectOne(@Param("id")Integer id);

    User login(@Param("userName")String username, @Param("password")String password);
}
