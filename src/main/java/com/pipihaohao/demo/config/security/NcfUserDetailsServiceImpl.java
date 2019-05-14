package com.pipihaohao.demo.config.security;

import com.pipihaohao.demo.entity.model.Login;
import com.pipihaohao.demo.entity.mysql.UserInfo;
import com.pipihaohao.demo.repo.mysql.UserInfoRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Auther: xfh
 * @Date: 2019/5/14
 * @Description:
 */
@Service("ncfUserDetailsService")
@Slf4j
public class NcfUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserInfoRepo userInfoRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserInfo userInfo = userInfoRepo.finByEmail(email);
        if (null == userInfo) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
        }
        log.debug("查询到用户信息userInfo={}", userInfo);
        Login login = new Login();
        login.setUserId(userInfo.getUid());
        login.setPassword(userInfo.getPassword());
        login.setEmail(userInfo.getEmail());
        login.setNickname(userInfo.getNickName());
        login.setCreateAt(userInfo.getCreateAt().toString());
        login.setUpdateAt(userInfo.getUpdateAt().toString());
        NcfUser ncfUser = NcfUserFactory.create(login);
        return ncfUser;
    }





}
