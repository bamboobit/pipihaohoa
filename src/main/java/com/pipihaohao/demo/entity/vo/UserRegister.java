package com.pipihaohao.demo.entity.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Auther: xfh
 * @Date: 2019/5/10
 * @Description:
 */
@Data
public class UserRegister {
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",message = "邮箱不合法")
    private String email;
    @NotNull
    @Length(min = 5,max = 20,message = "密码不合法")
    private String password;
}
