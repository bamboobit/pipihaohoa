package com.pipihaohao.demo.entity;

import lombok.Data;


import javax.persistence.*;

/**
 * @Auther: xfh
 * @Date: 2019/5/8
 * @Description:
 */
@Table(name = "userInfo")
@Data
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String userName;
    private String phone;
}
