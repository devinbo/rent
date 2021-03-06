package com.xxz.rent.portal.service;


/**
 * redis操作Service,
 * 对象和数组都以json形式进行存储
 * Created by macro on 2018/8/7.
 */
public interface RedisService {
    /**
     * 存储数据
     */
    void set(String key, String value);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 设置超期时间
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     * @param delta 自增步长
     */
    Long increment(String key, long delta);

    /**
     * 获取数据
     */
    Object getObj(String key);

    /**
     * 设置对象
     */
    void setObj(String key, Object value);

    /**
     * 设置对象
     */
    void setObj(String key, Object value, long expire);

    /**
     * 加入集合
     */
    void addList(String key, Object value);

    /**
     * 取出数据
     */
    void getList(String key, long len);
}
