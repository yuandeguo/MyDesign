package com.design.controller;
import com.design.params.LoginParam;
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
}
