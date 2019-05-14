package com.pipihaohao.demo.config.security;

import com.pipihaohao.demo.entity.model.Login;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: xfh
 * @Date: 2019/5/14
 * @Description:
 */
public final class NcfUserFactory {

    private NcfUserFactory() {
    }

    public static NcfUser create(Login user) {

        return new NcfUser(
                user.getUserId(),
                user.getExpiresIn(),
                user.getPassword(),
                user.getEmail(),
                user.getCreateAt(),
                user.getUpdateAt(),
                user.getNickname(),
                Collections.EMPTY_LIST
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        if (CollectionUtils.isEmpty(authorities)) {
            return null;
        }
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
