package com.xxz.rent.service;

import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.SmsMessage;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xxz
 */
@Transactional
public interface SmsMessageService {
    /**  功能描述 <br>
     * <分页加载系统消息>
     *
     * @param name
     * @param pageParam
     * @return java.util.List<com.xxz.rent.model.SmsMessage>
     * @date 2019-07-15 10:55
     */
    List<SmsMessage> list(String name, PageParam pageParam);

    /**  功能描述 <br>
     * <获取消息>
     *
     * @param id
     * @return com.xxz.rent.model.SmsMessage
     * @date 2019-07-15 14:23
     */
    SmsMessage getMessage(Long id);

    /**  功能描述 <br>
     * <添加消息>
     *
     * @param smsMessage
     * @return int
     * @date 2019-07-15 14:27
     */
    int addMessage(SmsMessage smsMessage);

    /**  功能描述 <br>
     * <修改公告信息>
     *
     * @param id
     * @param smsMessage
     * @return int
     * @date 2019-07-15 14:29
     */
    int updateMessage(Long id, SmsMessage smsMessage);

    /**  功能描述 <br>
     * <删除公告>
     *
     * @param id
     * @return int
     * @date 2019-07-15 17:16
     */
    int deleteMessage(Long id);
}
