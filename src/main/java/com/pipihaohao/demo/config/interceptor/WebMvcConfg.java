package com.pipihaohao.demo.config.interceptor;

import com.pipihaohao.demo.config.interceptor.ResponseMetricsInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: xfh
 * @Date: 2019/5/9
 * @Description:
 */
@Configuration
public class WebMvcConfg implements WebMvcConfigurer {

    private ResponseMetricsInterceptor responseMetricsInterceptor;


}
