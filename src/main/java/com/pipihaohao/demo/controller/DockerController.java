package com.pipihaohao.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: xfh
 * @create: 2019-08-10 11:10
 **/
@RestController
@Slf4j
public class DockerController {

    @RequestMapping("/")
    public String index() {
        log.info("Hello Docker");
        return "Hello Docker!";
    }
}
