package com.xxz.rent.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.xxz.rent.dao.OtoProductDao;
import com.xxz.rent.dto.OtoCommentResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.dto.enumerate.OtoProductStatus;
import com.xxz.rent.mapper.OtoProductMapper;
import com.xxz.rent.mapper.OtoProductReplyMapper;
import com.xxz.rent.model.OtoProduct;
import com.xxz.rent.model.OtoProductExample;
import com.xxz.rent.model.OtoProductReply;
import com.xxz.rent.model.OtoProductReplyExample;
import com.xxz.rent.service.OtoProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-06 11:31
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class OtoProductServiceImpl implements OtoProductService {

    @Autowired
    private OtoProductMapper otoProductMapper;

    @Autowired
    private OtoProductReplyMapper otoProductReplyMapper;
    @Autowired
    private OtoProductDao productDao;

    @Override
    public List<OtoProduct> list(String name, String[] startTime, Integer status, PageParam pageParam) {
        PageHelper.startPage(pageParam);
        OtoProductExample example = new OtoProductExample();
        OtoProductExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if (!StrUtil.isEmpty(name)) {
            criteria.andTitleLike("%" + name + "%");
        }
        if(startTime != null) {
            criteria.andCreateTimeBetween(DateUtil.parse(startTime[0]), DateUtil.parse(startTime[1]));
        }
        if(status != null) {
            criteria.andStatusEqualTo(status);
        }
        return otoProductMapper.selectByExample(example);
    }


    @Override
    public OtoProduct get(Long id) {
        return otoProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updatePrice(Long id, BigDecimal productPrice) {
        OtoProduct otoProduct = new OtoProduct();
        otoProduct.setId(id);
        otoProduct.setProductPrice(productPrice);
        return otoProductMapper.updateByPrimaryKeySelective(otoProduct);
    }

    @Override
    public int audit(Long id, Integer status, String refuseReason, Integer goodStatus, Integer reliableStatus) {
        OtoProduct otoProduct = new OtoProduct();
        otoProduct.setId(id);
        otoProduct.setAuditTime(new Date());
        otoProduct.setGoodStatus(goodStatus);
        otoProduct.setReliableStatus(reliableStatus);
        if(1 == status){
            //审核通过
            otoProduct.setStatus(OtoProductStatus.PUBLISH.getStatus());
        }else if(0 == status) {
            otoProduct.setStatus(OtoProductStatus.REFUSE.getStatus());
            otoProduct.setRefuseReason(refuseReason);
        }
        return otoProductMapper.updateByPrimaryKeySelective(otoProduct);
    }

    @Override
    public List<OtoCommentResult> commentList(Long productId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("create_time desc");
        return productDao.commentList(productId);
    }

    @Override
    public List<OtoProductReply> replyList(Long id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("create_time desc");
        OtoProductReplyExample example = new OtoProductReplyExample();
        example.createCriteria().andCommentIdEqualTo(id);
        return otoProductReplyMapper.selectByExample(example);
    }


}
