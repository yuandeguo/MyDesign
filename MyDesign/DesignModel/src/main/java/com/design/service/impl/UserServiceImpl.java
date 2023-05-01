package com.design.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.design.mapper.UserMapper;
import com.design.params.LoginParam;
import com.design.pojo.User;
import com.design.service.RedisService;
import com.design.service.UserService;
import com.design.utiles.ConstValue;
import com.design.utiles.R;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/4/23 15:43
 * @Description null
 */
@Service
public class UserServiceImpl  extends ServiceImpl<UserMapper, User>  implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisService redisService;


    @Override
    public User selectOne(Integer id) {

       return  userMapper.selectOne(id);
    }

    @Override
    public R login(LoginParam loginParam) {
        String username=loginParam.getUserName();
        String password=loginParam.getPassword();
        User user = userMapper.login(username,password);
        if (user == null) {
            return R.fail("账号/密码错误，请重新输入！");
        }
        String userKey= UUID.randomUUID().toString()+'-'+username;
        redisService.set(userKey,user.toString());
        return R.success(userKey);
    }
}
