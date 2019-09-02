package com.xxz.rent.dao;


import com.xxz.rent.dto.MemberMessageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xxz
 */
public interface UmsMemberMessageDao {


    List<MemberMessageResult> list(@Param("name") String name);

    MemberMessageResult getMessage(@Param("id") Long id);
}
