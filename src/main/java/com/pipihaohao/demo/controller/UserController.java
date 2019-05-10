package com.pipihaohao.demo.controller;

import com.pipihaohao.demo.entity.mysql.UserInfo;
import com.pipihaohao.demo.entity.vo.ErrorCode;
import com.pipihaohao.demo.entity.vo.UserRegister;
import com.pipihaohao.demo.repo.mysql.UserInfoRepo;
import com.pipihaohao.demo.utils.JsonResult;
import com.pipihaohao.demo.utils.RSAUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * @Auther: xfh
 * @Date: 2019/5/8
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Value("${PUBLIC_KEY}")
    private String public_key;
    @Autowired
    private UserInfoRepo userInfoRepo;

    @RequestMapping("/register")
    public JsonResult addUser(@Valid UserRegister userRegister, BindingResult check){
        if(check.hasErrors()){
            String msg = check.getAllErrors().get(0).getDefaultMessage();
            return JsonResult.buildErrorResult(msg,ErrorCode.ERROR_PARAMS.getCode(),null);
        }
        UserInfo userInfo = userInfoRepo.finByEmail(userRegister.getEmail());
        if(null != userInfo){
            return JsonResult.buildErrorResult(ErrorCode.REGIETERED_EMAIL.getMsg(),ErrorCode.REGIETERED_EMAIL.getCode(),null);
        }
        userInfo.setEmail(userRegister.getEmail());
        /*Map<String,String> map = RSAUtil.generateKeyPair();
        String password = RSAUtil.encrypt(userRegister.getPassword(),map.get("publicKey"));*/
        userInfo.setPassword(userRegister.getPassword());
        userInfoRepo.save(userInfo);
        return JsonResult.buildSucceedResult(ErrorCode.SUCCESS.getMsg(),ErrorCode.SUCCESS.getCode(),null);
    }
    @RequestMapping("/test")
    public String test(){
        log.info("in");
        return "111";
    }
}
