package com.pipihaohao.demo.config.security;

import com.alibaba.fastjson.JSON;
import com.pipihaohao.demo.Constants;
import com.pipihaohao.demo.entity.model.Login;
import com.pipihaohao.demo.entity.vo.ErrorCode;
import com.pipihaohao.demo.service.RedisService;
import com.pipihaohao.demo.utils.AESUtils;
import com.pipihaohao.demo.utils.JsonResult;
import com.pipihaohao.demo.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: xfh
 * @Date: 2019/5/14
 * @Description:
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Component
@Slf4j
public class NcfAuthenticationTokenFilter extends OncePerRequestFilter {

    @Value("${shanhaiguan.aes.key}")
    private String decryptAesKey;

    @Value("${jwt.header}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Value("${token.expire}")
    private int tokenExpire;
    @Value("${unAuth.api.list}")
    private String unAuthAPIS;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private RedisService redisService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        StringBuffer requestURL = request.getRequestURL();
        String serverPath = request.getServletPath();
        String authHeader = request.getHeader(this.tokenHeader);
        if (StringUtils.isNotBlank(authHeader) && authHeader.startsWith(tokenHead)) {
            final String authToken = authHeader.substring(tokenHead.length()); // The part after "Bearer "
            String username = tokenUtil.getUsernameFromToken(authToken);
            logger.info("checking authentication " + username);
            //白名单
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                Login user = getCurrentUser(authHeader);
                if (user == null) {
                    JsonResult jsonResult = JsonResult.buildErrorResult(ErrorCode.TOKEN_EXPIRE.getMsg(), ErrorCode.TOKEN_EXPIRE.getCode());
                    log.info("token过期, 需要重新登录, username:{}, token:{}", username, authToken);
                    new NcfAuthenticationEntryPoint().genResponse(response, jsonResult);
                    return;
                }
                UserDetails userDetails = NcfUserFactory.create(user);
                redisService.expire(authToken, tokenExpire, TimeUnit.MINUTES);
                boolean checkAuth = checkAuthentication(serverPath);
                if (checkAuth) {
                    logger.info("此用户 : " + username + ", 有权限访问:" + requestURL);
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                            request));
                    logger.info("authenticated user " + username + ", setting security context");
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    request.getSession().setAttribute(Constants.LOGIN_USER, encryptUser(user));
                }
            }
        }
        chain.doFilter(request, response);
    }

    private boolean checkAuthentication(String serverPath){
        //修改密码和登出接口，不需要权限验证
        String[] arr = unAuthAPIS.split(",");
        List<String> list = Arrays.asList(arr);
        if(list.contains(serverPath) || serverPath.contains("/act/") || serverPath.startsWith("/api/cs/fileInfo")){
            return true;
        }
        return false;
    }

    public Login getCurrentUser(String header) {
        String token = header.substring(tokenHead.length(), header.length());
        log.debug("获取用户token, token:{}", token);
        String loginJson = redisService.get(token);
        if (StringUtils.isBlank(loginJson)) {
            log.info("token失效, 未获取到用户信息, 需要重新登录");
            return null;
        }
        Login login = JSON.parseObject(loginJson, Login.class);
        log.debug("解析成login对象, login:{}", login);
        return login;
    }

    public String encryptUser(Login user){

        try {
            return AESUtils.encrypt(JSON.toJSONString(user), decryptAesKey);
        } catch (Exception e) {
            return null;
        }
    }

}
