package com.xxz.rent.portal.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.xxz.rent.dto.enumerate.OtoOrderStatus;
import com.xxz.rent.dto.enumerate.OtoProductStatus;
import com.xxz.rent.dto.enumerate.RentUnit;
import com.xxz.rent.mapper.OtoOrderMapper;
import com.xxz.rent.mapper.OtoOrderPaymentMapper;
import com.xxz.rent.mapper.OtoProductMapper;
import com.xxz.rent.mapper.OtoSiteMapper;
import com.xxz.rent.model.*;
import com.xxz.rent.portal.bo.exception.BusinessLogicException;
import com.xxz.rent.portal.model.dto.OtoOrderPaymentResult;
import com.xxz.rent.portal.model.dto.PublishDetailResult;
import com.xxz.rent.portal.model.dto.PublishProgress;
import com.xxz.rent.portal.service.OtoPublishService;
import com.xxz.rent.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-15 11:50
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
public class OtoPublishServiceImpl implements OtoPublishService {

    @Autowired
    private OtoProductMapper productMapper;
    @Autowired
    private OtoSiteMapper otoSiteMapper;
    @Autowired
    private OtoOrderMapper otoOrderMapper;
    @Autowired
    private OtoOrderPaymentMapper otoOrderPaymentMapper;
    @Autowired
    private OtoProductMapper otoProductMapper;

    @Autowired
    private UmsMemberService memberService;


    @Override
    public List<OtoProduct> list(Integer status, int pageNum, int pageSize) {
        UmsMember umsMember = memberService.getCurrentMember();
        PageHelper.startPage(pageNum, pageSize);
        OtoProductExample example = new OtoProductExample();
        OtoProductExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteStatusEqualTo(0).andMemberIdEqualTo(umsMember.getId());
        if (status != null) {
            //查询已签约
            if (status == 0) {
                criteria.andStatusIn(CollectionUtil.toList(
                        OtoProductStatus.AWAITSIGN.getStatus(),
                        OtoProductStatus.SIGNING.getStatus(),
                        OtoProductStatus.COMPLETE.getStatus()));
            } else if (status == 1) {
                criteria.andStatusEqualTo(OtoProductStatus.PUBLISH.getStatus());
            } else if (status == 2) {
                //待审核
                criteria.andStatusIn(CollectionUtil.toList(
                        OtoProductStatus.AUDIT.getStatus(),
                        OtoProductStatus.REFUSE.getStatus()
                ));
            } else {
                throw new BusinessLogicException("Status值错误！");
            }
        }
        List<OtoProduct> otoProductList = productMapper.selectByExample(example);
        return otoProductList;
    }

    @Override
    public int soldOut(Long id) {
        OtoProduct otoProduct = productMapper.selectByPrimaryKey(id);
        if (otoProduct == null) {
            throw new BusinessLogicException("无效ID");
        } else if (otoProduct.getStatus() != OtoProductStatus.PUBLISH.getStatus()) {
            throw new BusinessLogicException("不是发布中的产品，无法进行下架操作!");
        }
        otoProduct.setStatus(OtoProductStatus.CANCEL.getStatus());
        return productMapper.updateByPrimaryKeySelective(otoProduct);
    }

    @Override
    public int delete(Long id) {
        OtoProduct otoProduct = productMapper.selectByPrimaryKey(id);
        if (otoProduct == null) {
            throw new BusinessLogicException("无效ID");
        } else if (otoProduct.getStatus() != OtoProductStatus.CANCEL.getStatus()
                && otoProduct.getStatus() != OtoProductStatus.REFUSE.getStatus()) {
            throw new BusinessLogicException("非已取消、已拒绝的产品，无法删除");
        }
        otoProduct.setDeleteStatus(1);
        return productMapper.updateByPrimaryKeySelective(otoProduct);
    }


    @Override
    public PublishDetailResult detail(Long id) {
        PublishDetailResult result = new PublishDetailResult();
//        OtoOrder otoOrder = otoOrderMapper.selectByPrimaryKey(id);
//        Assert.notNull(otoOrder, "无效ID");
        OtoProduct otoProduct = productMapper.selectByPrimaryKey(id);
        Assert.notNull(otoProduct, "无效ID");
        BeanUtil.copyProperties(otoProduct, result);

        result.setMinRentNum(otoProduct.getRentLeastNum());
        result.setMaxRentNum(getMaxRentNum(otoProduct));

        List<PublishProgress> publishProgressList = createProgress(otoProduct);
        result.setProgressList(publishProgressList);
        return result;
    }

    /**
     * 创建进程
     */
    private List<PublishProgress> createProgress(OtoProduct otoProduct) {
        List<PublishProgress> publishProgressList = new ArrayList<>();
        //申请
        PublishProgress progress1 = new PublishProgress();
        progress1.setCompleted(true);
        progress1.setName("申请发布");
        progress1.setTime(otoProduct.getCreateTime());
        publishProgressList.add(progress1);

        PublishProgress progress2 = new PublishProgress();
        //审核
        if (otoProduct.getAuditTime() != null) {
            if (otoProduct.getStatus() == OtoOrderStatus.REFUSED.getStatus()) {
                progress2.setName("审核拒绝");
            } else {
                progress2.setName("审核通过");
            }
            progress2.setTime(otoProduct.getAuditTime());
            progress2.setCompleted(true);
        } else {
            progress2.setCompleted(false);
            progress2.setName("待审核");
            progress2.setTime(otoProduct.getAuditTime());
        }
        publishProgressList.add(progress2);

        PublishProgress progress3 = new PublishProgress();
        //判断是否进行待邮寄处理
        if(otoProduct.getSiteId() == null) {
            OtoSite otoSite = getLocation(null);
            //说明尚未邮寄
            progress3.setName("待邮寄");
            progress3.setNote("请待要上架产品邮寄至以下代理点");
            progress3.setCompleted(false);
            progress3.setLocation(otoSite != null ? otoSite.getLatitude() + "," + otoSite.getLongitude() : "");
        }else{
            OtoSite otoSite = getLocation(otoProduct.getSiteId());
            //说明已经邮寄
            progress3.setName("已邮寄");
            progress3.setNote("已将产品送至代理点：" + otoSite.getDetailAddress());
            progress3.setCompleted(true);
            progress3.setLocation(otoSite.getLatitude() + "," + otoSite.getLongitude());
        }
        publishProgressList.add(progress3);

        //判断是否上架
        PublishProgress progress4 = new PublishProgress();
        if(isCompletePublish(otoProduct.getStatus())) {
            progress4.setName("已上架");
            progress4.setTime(otoProduct.getPublishTime());
            progress4.setCompleted(true);
        }else{
            progress4.setName("待上架");
            progress4.setCompleted(false);
        }
        publishProgressList.add(progress4);

        return publishProgressList;
    }

    /**
     * 是否完成上架
     * @param status
     * @return
     */
    private boolean isCompletePublish(Integer status) {
        return Objects.equals(status, OtoProductStatus.PUBLISH.getStatus())
                || Objects.equals(status, OtoProductStatus.AWAITSIGN.getStatus())
                || Objects.equals(status, OtoProductStatus.SIGNING.getStatus())
                || Objects.equals(status, OtoProductStatus.COMPLETE.getStatus());
    }

    //获取位置
    private OtoSite getLocation(Long siteId) {
        OtoSiteExample example = new OtoSiteExample();
        OtoSiteExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if(siteId != null) {
            criteria.andIdEqualTo(siteId);
        }

        List<OtoSite> otoSiteList = otoSiteMapper.selectByExample(example);
        if(otoSiteList.size() == 0) {
            return null;
        }else{
            OtoSite otoSite = otoSiteList.get(0);
            return otoSite;
        }
    }


    private Integer getMaxRentNum(OtoProduct otoProduct) {
        //最短起租数
        Integer rentLeastNum = otoProduct.getRentLeastNum() != null ? otoProduct.getRentLeastNum() : 0;
        //根据最迟归还日期，
        Date latestDate = otoProduct.getRentLatestDate();
        Date nowDate = new Date();
        if (otoProduct.getRentUnit() == RentUnit.DAY.getValue()) {
            long betweenDay = DateUtil.betweenDay(nowDate, latestDate, true);
            //最大起租数需大于最短起租数， 否则不设置最大起租数
            if (betweenDay > rentLeastNum) {
                return (int) betweenDay;
            }
        } else if (otoProduct.getRentUnit() == RentUnit.WEEK.getValue()) {
            long betweenDay = DateUtil.betweenDay(nowDate, latestDate, true);
            if ((int) betweenDay / 7 > rentLeastNum) {
                return (int) betweenDay / 7;
            }
        } else if (otoProduct.getRentUnit() == RentUnit.MONTH.getValue()) {
            long betweenMonth = DateUtil.betweenMonth(nowDate, latestDate, true);
            if (betweenMonth > rentLeastNum) {
                return (int) betweenMonth;
            }
        } else if (otoProduct.getRentUnit() == RentUnit.YEAR.getValue()) {
            long betweenYear = DateUtil.betweenYear(nowDate, latestDate, true);
            if (betweenYear > rentLeastNum) {
                return (int) betweenYear;
            }
        }
        return null;
    }


    @Override
    public List<OtoSite> agencyList(String key, String city) {
        OtoSiteExample example = new OtoSiteExample();
        OtoSiteExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        final String all = "all";
        if(StrUtil.isEmpty(city)) {
            //默认查询苏州市
            criteria.andCityEqualTo("苏州市");
        }else if(!StrUtil.equals(city, all, true)){
            criteria.andCityEqualTo(city);
        }
        if(!StrUtil.isEmpty(key)) {
//            OtoSiteExample.Criteria criteria1 = example.createCriteria();
//            criteria1.andNameLike("%" + key + "%");
//            example.or() .andCityLike("%" + key + "%");
//            example.or().andDetailAddressLike("%" + key + "%");
            criteria.andNameLike("%" + key + "%");
        }
        return otoSiteMapper.selectByExample(example);
    }

    @Override
    public OtoOrderPaymentResult rentDetail(Long id) {
        OtoOrderPaymentExample example = new OtoOrderPaymentExample();
        example.createCriteria().andOrderIdEqualTo(id);
        List<OtoOrderPayment> otoOrderPaymentList = otoOrderPaymentMapper.selectByExample(example);
        if(otoOrderPaymentList == null || otoOrderPaymentList.size() == 0) {
            throw new BusinessLogicException("无效ID或非签约订单");
        }
        //进行排序操作， 按照 1 逾期 -> 0 待支付 -> 3 尚未开始 -> 2 已支付
        //定义一个排列规则
        List<Integer> regulation = Arrays.asList(new Integer[]{1, 0, 3, 2});
        Collections.sort(otoOrderPaymentList, new Comparator<OtoOrderPayment>() {
            @Override
            public int compare(OtoOrderPayment o1, OtoOrderPayment o2) {
                return regulation.indexOf(o1.getStatus()) - regulation.indexOf(o2.getStatus());
            }
        });

        OtoOrder otoOrder = otoOrderMapper.selectByPrimaryKey(id);
        OtoOrderPaymentResult result = new OtoOrderPaymentResult();
        BeanUtil.copyProperties(otoOrder, result);
        result.setOtoOrderPaymentList(otoOrderPaymentList);

        OtoProduct otoProduct = otoProductMapper.selectByPrimaryKey(otoOrder.getProductId());
        result.setPic(otoProduct.getPic());
        return result;
    }

}
