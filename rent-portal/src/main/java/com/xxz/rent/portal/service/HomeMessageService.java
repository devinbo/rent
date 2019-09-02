package com.xxz.rent.portal.service;

import com.xxz.rent.model.SmsMessage;
import com.xxz.rent.model.UmsMemberMessage;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xxz
 */
@Transactional
public interface HomeMessageService {
    /**  功能描述 <br>
     * <查询会员未读消息>
     *
     * @param
     * @return java.lang.Long
     * @date 2019-07-16 13:58
     */
    Long hasNoReadMsg();

    /**  功能描述 <br>
     * <分页查询公告>
     *
     * @param
     * @param pageNum
     * @param pageSize
     * @return java.util.List<com.xxz.rent.model.SmsMessage>
     * @date 2019-07-16 13:59
     */
    List<SmsMessage> getCommonMessage(Integer pageNum, Integer pageSize);

    /**  功能描述 <br>
     * <分页查询会员消息>
     *
     * @param pageNum
     * @param pageSize
     * @return java.util.List<com.xxz.rent.model.UmsMemberMessage>
     * @date 2019-07-16 14:43
     */
    List<UmsMemberMessage> getMemberMessages(Integer pageNum, Integer pageSize);
}
