package com.xxz.rent.service;

import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.SmsHomeActivity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xxz
 */
@Transactional
public interface OmsActivityService {

    /**  功能描述 <br>
     * <分页加载活动列表>
     *
     * @param name
     * @param pageParam
     * @return java.util.List<com.xxz.rent.controller.OmsActivity>
     * @date 2019-07-12 13:41
     */
    List<SmsHomeActivity> list(String name, PageParam pageParam);

    /**  功能描述 <br>
     * <添加活动>
     *
     * @param smsHomeActivity
     * @return int
     * @date 2019-07-12 14:44
     */
    int create(SmsHomeActivity smsHomeActivity);

    /**  功能描述 <br>
     * <修改活动>
     *
     *
     * @param id
     * @param smsHomeActivity
     * @return int
     * @date 2019-07-12 14:50
     */
    int update(Long id, SmsHomeActivity smsHomeActivity);

    /**
     * 删除活动
     * @param ids
     * @return
     */
    int delete(List<Long> ids);

    /**  功能描述 <br>
     * <根据ID加载活动>
     *
     * @param id
     * @return com.xxz.rent.model.SmsHomeActivity
     * @date 2019-07-15 16:20
     */
    SmsHomeActivity get(Long id);
}
