package com.xxz.rent.dao;


import com.xxz.rent.dto.UmsMemberAuthResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsMemberAuthDao {

    List<UmsMemberAuthResult> list(@Param("name") String name);
}
