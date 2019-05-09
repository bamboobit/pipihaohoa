package com.pipihaohao.demo.config.interceptor;

import com.pipihaohao.demo.utils.ApplicationContextHolder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * @Auther: xfh
 * @Date: 2019/5/9
 * @Description:
 */
@Lazy
@Configuration
public class InterceptorConfig extends WebMvcConfg {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ResponseMetricsInterceptor metricsInterceptor = new ResponseMetricsInterceptor();
        ApplicationContextHolder.getApplicationContext()
                .getAutowireCapableBeanFactory();
        registry.addInterceptor(metricsInterceptor).addPathPatterns("/**");
    }
}
