package com.xxz.rent.service;

/**
 * redis操作Service,
 * 对象和数组都以json形式进行存储
 * @author xxz
 */
public interface RedisService {
    /**  功能描述 <br>
     * <存储数据>
     *
     * @param key
     * @param value
     * @return void
     * @date 2019-06-10 15:12
     */
    void set(String key, String value);

    /**  功能描述 <br>
     * <获取数据>
     *
     * @param key
     * @return java.lang.String
     * @date 2019-06-10 15:12
     */
    String get(String key);

    /**  功能描述 <br>
     * <设置超期时间>
     *
     * @param key
     * @param expire
     * @return boolean
     * @date 2019-06-10 15:13
     */
    boolean expire(String key, long expire);

    /**  功能描述 <br>
     * <删除数据>
     *
     * @param key
     * @return void
     * @date 2019-06-10 15:13
     */
    void remove(String key);

    /**  功能描述 <br>
     * <自增操作>
     *
     * @param key
     * @param delta:步长
     * @return java.lang.Long
     * @date 2019-06-10 15:13
     */
    Long increment(String key, long delta);

    /**  功能描述 <br>
     * <获取数据>
     *
     * @param key
     * @return java.lang.Object
     * @date 2019-06-10 15:14
     */
    Object getObj(String key);

    /**  功能描述 <br>
     * <设置对象>
     *
     * @param key
     * @param value
     * @return void
     * @date 2019-06-10 15:14
     */
    void setObj(String key, Object value);

    /**  功能描述 <br>
     * <设置对象>
     *
     * @param key
     * @param value
     * @param expire
     * @return void
     * @date 2019-06-10 15:14
     */
    void setObj(String key, Object value, long expire);

    /**  功能描述 <br>
     * <移除数据>
     *
     * @param key
     * @return void
     * @date 2019-06-10 16:24
     */
    void removeObj(String key);
}
