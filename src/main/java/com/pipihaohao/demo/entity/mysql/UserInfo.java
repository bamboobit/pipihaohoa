package com.pipihaohao.demo.entity.mysql;

import lombok.Data;


import javax.persistence.*;
import java.sql.Timestamp;

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
    private String password;
    private String email;
    private Timestamp createAt;
    private Timestamp updateAt;
    private String nickName;

    @PrePersist
    public void prePersist() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        createAt = timestamp;
    }
}
