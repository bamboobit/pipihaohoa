package com.pipihaohao.demo.controller;

import com.alibaba.fastjson.JSON;
import com.pipihaohao.demo.config.security.NcfUser;
import com.pipihaohao.demo.entity.model.LoginParam;
import com.pipihaohao.demo.service.RedisService;
import com.pipihaohao.demo.utils.JsonResult;
import com.pipihaohao.demo.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: xfh
 * @Date: 2019/5/14
 * @Description:
 */
@RestController
@Slf4j
public class LoginController {
    @Value("${token.expire}")
    private int tokenExpire;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private RedisService redisService;


    @RequestMapping("/login")
    public JsonResult login(@RequestBody LoginParam loginParam) {
        UserDetails userDetails = null;
        try {
            UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(
                    loginParam.getEmail(), loginParam.getPassword());
            // Perform the security
            Authentication authentication = authenticationManager.authenticate(upToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            Object principal = authentication.getPrincipal();
            userDetails = (UserDetails) principal;
        } catch (Exception e) {
            return JsonResult.buildErrorResult("用户名或密码错误", null);
        }
        // Reload password post-security so we can generate token
        NcfUser ncfUser = (NcfUser) userDetails;
        String token = tokenUtil.generateToken(userDetails);
        log.info("获取到token往redis设置, token:{}", token);
        redisService.set(token, JSON.toJSONString(ncfUser));
        /*String userLoginKey = Constants.REDIS_USERLOGIN + ncfUser.getUsername() + "_" + ncfUser.getId();
        redisService.set(userLoginKey, token);
        redisService.expire(token, tokenExpire, TimeUnit.MINUTES);
        redisService.expire(userLoginKey, tokenExpire, TimeUnit.MINUTES);
        Map map =
        map.put("token", token);*/
        return JsonResult.buildSucceedResult("登录成功",null, null);
    }
}
