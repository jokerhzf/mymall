package com.hzf.mymall.service;

/**
 * @author：010980380
 * @date:2020-10-27
 * @verison:1.0.0
 * @description：Redis 操作Service，对象和数组都以json形式进行存储
 */

public interface RedisService {
    /**
     * 存储数据
     * @param key
     * @param value
     * @return void
     * @author huangzifan
     * @since 2020-10-27 11:03
     */
    void set(String key,String value);

    /**
     * 获取数据
     * @param key
     * @return java.lang.String
     * @author huangzifan
     * @since 2020-10-27 11:03
     */
    String get(String key);

    /**
     * 设置过期时间
     * @param key
     * @param expire 过期时间
     * @return boolean
     * @author huangzifan
     * @since 2020-10-27 11:03
     */
    boolean expire(String key,long expire);

    /**
     * 删除数据
     * @param key
     * @return void
     * @author huangzifan
     * @since 2020-10-27 11:04
     */
    void remove(String key);

    /**
     * 自增操作
     * @param key
     * @param delta  自增步长
     * @return java.lang.Long
     * @author huangzifan
     * @since 2020-10-27 11:04
     */
    Long increment(String key,long delta);
}
