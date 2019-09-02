package com.xxz.rent.portal.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author xxz
 */
public interface SmsMessageDao {

    Long getUnReadMessageCount(@Param("memberId") Long memberId);
}
