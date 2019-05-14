package com.pipihaohao.demo.entity.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Auther: xfh
 * @Date: 2019/5/14
 * @Description:
 */
@Data
public class Login {
    private Integer userId;
    private Integer expiresIn;
    private String password;
    private String email;
    private String createAt;
    private String updateAt;
    private String nickname;

}
