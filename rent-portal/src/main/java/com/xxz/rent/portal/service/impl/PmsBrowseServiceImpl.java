package com.xxz.rent.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.xxz.rent.mapper.UmsMemberBrewosProductMapper;
import com.xxz.rent.model.UmsMemberBrewosProductExample;
import com.xxz.rent.portal.dao.PmsBrowseDao;
import com.xxz.rent.portal.model.dto.OtoBrowseResult;
import com.xxz.rent.portal.model.dto.PmsBrowseResult;
import com.xxz.rent.portal.service.PmsBrowseService;
import com.xxz.rent.portal.service.UmsMemberService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-10-10 10:55
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class PmsBrowseServiceImpl implements PmsBrowseService {

    @Autowired
    private PmsBrowseDao pmsBrowseDao;
    @Autowired
    private UmsMemberService umsMemberService;

    @Autowired
    private UmsMemberBrewosProductMapper brewosProductMapper;

    @Override
    public List<PmsBrowseResult> selfBrowseList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return pmsBrowseDao.groupByBrowseList(umsMemberService.getCurrentMember().getId());
    }

    @Override
    public List<OtoBrowseResult> otoBrowseList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return pmsBrowseDao.otoBrowseList(umsMemberService.getCurrentMember().getId());
    }
}
