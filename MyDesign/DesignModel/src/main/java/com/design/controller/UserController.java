package com.design.controller;
import com.design.params.LoginParam;
import com.design.pojo.User;
import com.design.service.UserService;
import com.design.utiles.R;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/4/23 15:32
 * @Description null
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;
    @PostMapping("/login")
    public R login(@RequestBody @Validated LoginParam loginParam, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
        {
          return   R.fail("账号/密码不能为空，请重新输入！");
        }
        return userService.login(loginParam);
    }

    /**
     * 检查账号是否可用的接口
     * @param userCheckParam 接收检查的账号实体 内部有参数校验注解
     * @param result 获取校验结果的实体对象
     * @return 返回封装结果R对象即可
     *
     * BindingResult 获取userCheckParam的校验结果，  必须紧挨着userCheckParam
     * //检查是否符合检验注解的规则  符合 false  不符合 true
     *     boolean b = result.hasErrors();
     *
     */
    /**
     * 用户注册
     * Validated是使User实体属性上的注解生效，可以校验
     * @param user
     * @param result
     * @return
     */
    @PostMapping("register")
    public R register(@RequestBody @Validated User user, BindingResult result)
    {
        if(result.hasErrors())
        {//存在异常，证明请求参数不符合注解要求

            return R.fail("参数异常,不可注册!");
        }
        return userService.register(user);


    }



}
