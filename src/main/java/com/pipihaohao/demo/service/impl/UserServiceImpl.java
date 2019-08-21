package com.pipihaohao.demo.service.impl;

import com.pipihaohao.demo.repo.mysql.UserInfoRepo;
import com.pipihaohao.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: xfh
 * @Date: 2019/5/10
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoRepo userInfoRepo;
    @Override
    public Integer findMaxId(){
        return 0;
    }
}
