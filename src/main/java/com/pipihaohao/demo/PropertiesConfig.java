package com.pipihaohao.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: xfh
 * @create: 2019-07-02 14:03
 **/

@Component
public class PropertiesConfig implements InitializingBean {

    @Autowired
    private Environment env;

    public static Boolean swaggerEnable;

    @Override
    public void afterPropertiesSet() throws Exception{

        //t:配置文件为空的话，默认值false
        swaggerEnable = env.getProperty("swagger.enable", Boolean.class, true);
    }
}
