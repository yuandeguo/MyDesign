package com.design.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    @Override
    public R register(User user) {
        //1.检查账号是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",user.getUserName());
        //数据库查询
        Integer total = userMapper.selectCount(queryWrapper);

        if (total > 0){
            return R.fail("账号已经存在,不可注册!");
        }
        //2.密码加密处理,注意要加盐
        /**
         * MD5 一种不可逆转加密方式, 只能加密不能解密!
         *     固定的明文加密以后的密文是固定!
         *     123456  --> 加密 ---> 1111111
         *     注册是加密以后存在密文!
         *     登录实加密以后,用密文进行数据库对比!
         * MD5可以暴力破解:
         *     穷举法
         *     简单的字符串都是不安全!
         *     提示用户密码复杂度!
         *     加盐处理    用户的密码 1 + 字符串[盐] 9999 = 10000
         */


        user.setPassword(user.getPassword());

        //3.插入数据库数据
        int rows = userMapper.insert(user);
        //4.返回封装结果
        if (rows == 0){

            return R.fail("注册失败!请稍后再试!");
        }



        return R.success("注册成功!");



    }
}
