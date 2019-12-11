package com.xxz.rent.mapper;

import com.xxz.rent.model.OtoSite;
import com.xxz.rent.model.OtoSiteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtoSiteMapper {
    long countByExample(OtoSiteExample example);

    int deleteByExample(OtoSiteExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OtoSite record);

    int insertSelective(OtoSite record);

    List<OtoSite> selectByExample(OtoSiteExample example);

    OtoSite selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OtoSite record, @Param("example") OtoSiteExample example);

    int updateByExample(@Param("record") OtoSite record, @Param("example") OtoSiteExample example);

    int updateByPrimaryKeySelective(OtoSite record);

    int updateByPrimaryKey(OtoSite record);
}