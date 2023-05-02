package com.design.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.design.params.LoginParam;
import com.design.pojo.User;
import com.design.utiles.R;
import org.apache.ibatis.annotations.Param;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/4/23 15:42
 * @Description null
 */
public interface UserService extends IService<User> {
    User selectOne(Integer id);

    R login(LoginParam loginParam);

    R register(User user);
}
