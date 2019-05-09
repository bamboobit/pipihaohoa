package com.pipihaohao.demo.config.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @Auther: xfh
 * @Date: 2019/5/9
 * @Description:
 */
@Slf4j
public class ResponseMetricsInterceptor extends HandlerInterceptorAdapter {

    private static final String TRACING_ID = "TRACING_ID";
    private static final String RESPONSE_TIME = "RESPONSE_TIME";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    /*String tracingId = RandomStringUtils.randomAlphanumeric(10);
    MDC.put(TRACING_ID, tracingId);*/
        log.info("service.tracing.start.请求开始 url={}", request.getServletPath());
        log.info(request.getParameter("name"));
        request.setAttribute(RESPONSE_TIME, System.currentTimeMillis());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        try {
            log.info("service.tracing.end.请求结束 url={}, 消耗时间：{}ms", request.getServletPath(),
                    System.currentTimeMillis() - Long.valueOf(
                            Objects.toString(request.getAttribute(RESPONSE_TIME), "0")));
        } catch (NumberFormatException e) {
        } finally {
            MDC.remove(TRACING_ID);
        }
        super.afterCompletion(request, response, handler, ex);
    }
}
