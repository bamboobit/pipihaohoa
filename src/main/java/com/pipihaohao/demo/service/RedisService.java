package com.pipihaohao.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: xfh
 * @Date: 2019/5/9
 * @Description:
 */
public interface RedisService {
    /**
     * redis设置值
     *
     * @param key   key
     * @param value value
     */
    void set(String key, String value);

    /**
     * redis获取值
     *
     * @param key key
     * @return String
     */
    String get(String key);

    /**
     * redis删除值
     *
     * @param key key
     */
    void delete(String key);

    /**
     * redis删除值
     *
     * @param key
     */
    void delete(Collection key);

    /**
     * @param timeout 基数
     * @description 设置过期时间
     * @author zhangyanglei
     * @date 2017/9/1 17:39
     */
    Boolean expire(String key, long timeout, TimeUnit timeUnit);

    /**
     * @param key
     * @param timeUnit 时间单位
     * @description 获取过期时间
     */
    Long getExpire(String key, TimeUnit timeUnit);

    Boolean flushDB();

    Long incr(String key);

    Long decr(String key);

    List<String> multiGet(Collection keys);

    void multiSet(Map<String, String> map);


}
