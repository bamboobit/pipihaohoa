/*
package com.pipihaohao.demo.controller;

import com.pipihaohao.demo.entity.pg.AccountInfo;
import com.pipihaohao.demo.repo.pg.AccountRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * @Auther: xfh
 * @Date: 2019/5/9
 * @Description:
 *//*

@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Autowired
    private AccountRepo accountRepo;

    @RequestMapping("/add")
    public String addAccount(String orgName){
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setOrgName(orgName);
        accountRepo.save(accountInfo);
        return "success";
    }
}
*/
