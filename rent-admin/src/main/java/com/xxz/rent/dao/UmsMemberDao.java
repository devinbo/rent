package com.xxz.rent.dao;

import com.xxz.rent.common.api.CommonResult;
import com.xxz.rent.dto.UmsMemberResult;
import com.xxz.rent.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsMemberDao {

    UmsMemberResult getMemberDetail(@Param("id") Long id);

    UmsMemberReceiveAddress getReceiveAddressByMemberId(@Param("id") Long id);

    UmsMemberKinsfolk getUmsMemberKinsfolkByMemberId(@Param("id") Long id);

    UmsMemberLink getUmsMemberLinkByMemberId(@Param("id") Long id);

    UmsMemberRealinform getUmsMemberRealinformByMemberId(@Param("id") Long id);

    UmsMemberAuthRelation getUmsMemberAuthRelationByMemberId(@Param("id") Long id);

    List<UmsMember> getMemberByKeyword(@Param("keyword") String keyword);
}
