package com.pipihaohao.demo.entity.mysql;

import lombok.Data;


import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Auther: xfh
 * @Date: 2019/5/8
 * @Description:
 */
@Table(name = "user")
@Data
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private Timestamp createAt;
    private Timestamp updateAt;
    private String phone;
    private String email;
    private String password;

    @PrePersist
    public void prePersist() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        createAt = timestamp;
    }
}
