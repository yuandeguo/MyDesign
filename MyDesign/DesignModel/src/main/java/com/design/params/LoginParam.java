package com.design.params;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/4/23 21:04
 * @Description null
 */
@Data
@ToString
public class LoginParam {
    @NotBlank(message = "用户名不能为空")
    private String userName;
    @NotBlank(message = "密码不能为空")
    private String password;
}
