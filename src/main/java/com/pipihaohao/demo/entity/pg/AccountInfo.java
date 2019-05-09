package com.pipihaohao.demo.entity.pg;

import lombok.Data;

import javax.persistence.*;

/**
 * @Auther: xfh
 * @Date: 2019/5/9
 * @Description:
 */
@Table(name = "account")
@Entity
@Data
public class AccountInfo {
    @Id
    @GeneratedValue
    private Integer aid;
    @Column(name = "orgName")
    private String orgName;
}
