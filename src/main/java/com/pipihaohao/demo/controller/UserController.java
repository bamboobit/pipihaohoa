package com.pipihaohao.demo.controller;

import com.pipihaohao.demo.entity.UserInfo;
import com.pipihaohao.demo.repo.UserInfoRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: xfh
 * @Date: 2019/5/8
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoRepo userInfoRepo;

    @RequestMapping("/add")
    public String addUser(@RequestParam("name") String name, @RequestParam("phone") String phone){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(name);
        userInfo.setPhone(phone);
        userInfoRepo.save(userInfo);
        return "成功";
    }
    @RequestMapping("/test")
    public String test(){
        log.info("in");
        return "111";
    }
}
