package com.pipihaohao.demo.controller;

import com.pipihaohao.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: xfh
 * @Date: 2019/5/9
 * @Description:
 */
@RequestMapping("/redis")
@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;
    @RequestMapping("/test")
    public String redisTest(Integer age){
        redisService.set("xfh",age.toString());
        return redisService.get("xfh");
    }
}
