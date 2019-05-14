package com.pipihaohao.demo.config.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Auther: xfh
 * @Date: 2019/5/14
 * @Description:
 */
public class NcfUser implements UserDetails {
    private Integer userId;
    private Integer expiresIn;
    private String password;
    private String email;
    private String createAt;
    private String updateAt;
    private String nickname;
    private Collection<? extends GrantedAuthority> authorities;

    public NcfUser(
            Integer userId,
            Integer expiresIn,
            String password,
            String email,
            String createAt,
            String updateAt,
            String nickname,
            Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.expiresIn = expiresIn;
        this.password = password;
        this.email = email;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.nickname = nickname;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nickname;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}

