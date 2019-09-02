package com.xxz.rent.service.impl;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.mapper.OtoOrderMapper;
import com.xxz.rent.model.CmsSubjectExample;
import com.xxz.rent.model.OtoOrder;
import com.xxz.rent.model.OtoOrderExample;
import com.xxz.rent.service.OtoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-13 11:36
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class OtoOrderServiceImpl implements OtoOrderService {

    @Autowired
    private OtoOrderMapper otoOrderMapper;

    @Override
    public List<OtoOrder> list(String[] startTime, Integer status, String memberName, String productName, PageParam pageParam) {
        PageHelper.startPage(pageParam);
        OtoOrderExample example = new OtoOrderExample();
        OtoOrderExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if (startTime != null && startTime.length > 0) {
            criteria.andCreateTimeBetween(DateUtil.parse(startTime[0]), DateUtil.parse(startTime[1]));
        }
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        if (memberName != null) {
            criteria.andMemberPhoneLike("%" + memberName + "%");
            example.or().andMemberUsernameLike("%" + memberName + "%");
        }
        if (productName != null) {
            criteria.andProductTitleLike("%" + productName + "%");
        }
        return otoOrderMapper.selectByExample(example);
    }
}
