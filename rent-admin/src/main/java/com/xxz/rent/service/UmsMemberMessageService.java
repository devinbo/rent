package com.xxz.rent.service;

import com.xxz.rent.dto.MemberMessageResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.SmsMessage;
import com.xxz.rent.model.UmsMemberMessage;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xxz
 */
@Transactional
public interface UmsMemberMessageService {

    List<MemberMessageResult> list(String name, PageParam pageParam);

    MemberMessageResult getMessage(Long id);

    int addMessage(UmsMemberMessage umsMemberMessage);

    int updateMessage(Long id, UmsMemberMessage umsMemberMessage);

    int deleteMessage(Long id);
}
