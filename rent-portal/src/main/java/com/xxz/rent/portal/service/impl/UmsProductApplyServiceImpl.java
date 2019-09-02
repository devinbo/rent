package com.xxz.rent.portal.service.impl;

import cn.hutool.json.JSONUtil;
import com.xxz.rent.dto.enumerate.OrderStatus;
import com.xxz.rent.mapper.*;
import com.xxz.rent.model.*;
import com.xxz.rent.portal.bo.exception.BusinessLogicException;
import com.xxz.rent.portal.dao.OmsOrderDao;
import com.xxz.rent.portal.dao.PmsProductDao;
import com.xxz.rent.portal.dao.SmsCouponHistoryDao;
import com.xxz.rent.portal.dao.UmsProductApplyDao;
import com.xxz.rent.portal.model.dto.ApplyParam;
import com.xxz.rent.portal.model.dto.ApplyResult;
import com.xxz.rent.portal.model.dto.PreOrderResult;
import com.xxz.rent.portal.model.dto.SkuProps;
import com.xxz.rent.portal.model.enumerate.PromotionStatus;
import com.xxz.rent.portal.service.RedisService;
import com.xxz.rent.portal.service.UmsMemberService;
import com.xxz.rent.portal.service.UmsProductApplyService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-18 15:03
 * @description：订单申请流程service
 * @modified By：
 * @version: ：1.0
 */
@Service
public class UmsProductApplyServiceImpl implements UmsProductApplyService {

    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private UmsMemberMapper memberMapper;
    @Autowired
    private UmsMemberAuthRelationMapper authRelationMapper;
    @Autowired
    private UmsMemberReceiveAddressMapper memberReceiveAddressMapper;
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private PmsProductDao productDao;
    @Autowired
    private PmsSkuStockMapper skuStockMapper;
    @Autowired
    private UmsProductApplyDao productApplyDao;
    @Autowired
    private OmsOrderMapper orderMapper;
    @Autowired
    private OmsOrderDao orderDao;
    @Autowired
    private OmsOrderItemMapper orderItemMapper;
    @Autowired
    private PmsProductAttributeMapper productAttributeMapper;
    @Autowired
    private PmsProductAttributeValueMapper productAttributeValueMapper;
    @Autowired
    private RedisService redisService;
    @Autowired
    private SmsCouponHistoryDao couponHistoryDao;
    @Autowired
    private SmsCouponHistoryMapper couponHistoryMapper;
    @Autowired
    private UmsMemberFreemoneyLogMapper umsMemberFreemoneyLogMapper;
    @Autowired
    private OmsOrderSettingMapper orderSettingMapper;

    @Value("${redis.key.prefix.orderId}")
    private String REDIS_KEY_PREFIX_ORDER_ID;
    @Value("redis:key:prefix:waitPay")
    private String WAITPAY;


    @Override
    public PreOrderResult getPreOrderInfo(Long skuId) {

        UmsMember umsMember = memberService.getCurrentMember();
        //检查客户是否进行了实名认证，
        UmsMemberAuthRelationExample example = new UmsMemberAuthRelationExample();
        example.createCriteria().andMemberIdEqualTo(umsMember.getId());
        List<UmsMemberAuthRelation> authRelationList = authRelationMapper.selectByExample(example);
        UmsMemberAuthRelation authRelation = authRelationList.get(0);
        if (!Objects.equals(authRelation.getIdentityStatus(), 1)) {
            throw new BusinessLogicException("请先完成实名认证！");
        }
        PmsProduct pmsProduct = productDao.getProductBySkuId(skuId);
        if (pmsProduct == null) {
            throw new BusinessLogicException("该属性的产品不存在！");
        }
        //查询是否有效产品
        PreOrderResult preOrderResult = productApplyDao.productApplyDao(skuId);
        if(preOrderResult == null) {
            throw new BusinessLogicException("该属性的产品不存在！");
        }
        //判断产品是否产于了首期租金减免活动
        if (1 == preOrderResult.getPromotionType()) {
            //判断首期租金
            BigDecimal sub = preOrderResult.getFirstEachPriceSub() == null ? new BigDecimal(0) : preOrderResult.getFirstEachPriceSub();
            preOrderResult.setFirstIssuePrice(preOrderResult.getEachPrice().subtract(sub));
        } else {
            preOrderResult.setFirstIssuePrice(preOrderResult.getEachPrice());
        }
        //TODO 运费处理，

        //会员当前的免押额度
        UmsMember memberDb = memberService.getById(umsMember.getId());
        BigDecimal freeMoney = memberDb.getFreeMoney();
        preOrderResult.setFreeDecimal(freeMoney);

        //应支付押金
        if(2 == preOrderResult.getPromotionType()) {
            //免押金产品
            preOrderResult.setAdvanceMoney(new BigDecimal(0));
        }else{
            //非免押产品处理
            BigDecimal advanceMoney = preOrderResult.getPrice().subtract(freeMoney);
            if (advanceMoney.intValue() > 0) {
                preOrderResult.setAdvanceMoney(advanceMoney);
            } else {
                preOrderResult.setAdvanceMoney(new BigDecimal(0));
            }
        }
        //加载收货人信息
        UmsMemberReceiveAddressExample addressExample = new UmsMemberReceiveAddressExample();
        addressExample.createCriteria().andMemberIdEqualTo(umsMember.getId());
        addressExample.setOrderByClause("default_status desc");
        List<UmsMemberReceiveAddress> memberReceiveAddressesList = memberReceiveAddressMapper.selectByExample(addressExample);
        if (memberReceiveAddressesList != null && memberReceiveAddressesList.size() > 0) {
            preOrderResult.setAddress(memberReceiveAddressesList.get(0));
        }

        //加载当前可用优惠券信息
        List<PreOrderResult.CouponUseInfo> smsCouponList = productApplyDao.getCanUseCoupon(pmsProduct.getProductCategoryId(), pmsProduct.getId(), memberDb.getId());
        preOrderResult.setCouponList(smsCouponList);
        return preOrderResult;
    }

    @Override
    public ApplyResult apply(ApplyParam applyParam) {
        UmsMember umsMember = memberService.getCurrentMemberByDb();
        PmsProduct pmsProduct = productDao.getProductBySkuId(applyParam.getSkuId());
        if(pmsProduct == null) {
            throw new BusinessLogicException("产品已失效！");
        }else if(1 == pmsProduct.getNoticeStatus()) {
            throw new BusinessLogicException("该产品为预告产品，无法申请!");
        }else if(PromotionStatus.FREECHARGE.getStatus().equals(pmsProduct.getPromotionType())) {
            //如果该产品是免押金的，那么查看是否已经有该产品了
            if(orderDao.countBySameProduct(pmsProduct.getId())) {
                throw new BusinessLogicException("您已经申请过该产品，请先完成之前的订单");
            }
        }
        //查询sku信息
        PmsSkuStock pmsSkuStock = skuStockMapper.selectByPrimaryKey(applyParam.getSkuId());
        //创建订单
        OmsOrder omsOrder = createOrder(pmsProduct, pmsSkuStock, umsMember, applyParam);

        //创建订单项信息
        OmsOrderItem  omsOrderItem = createOrderItem(pmsProduct, pmsSkuStock);
        omsOrderItem.setOrderId(omsOrder.getId());
        omsOrderItem.setOrderSn(omsOrder.getOrderSn());
        orderItemMapper.insertSelective(omsOrderItem);

        //返回待支付和订单ID信息
        ApplyResult applyResult = new ApplyResult();
        applyResult.setOrderId(omsOrder.getId());
        applyResult.setPayAmount(omsOrder.getPayAmount());
        return applyResult;
    }

    /**
     * 创建订单
     */
    private OmsOrder createOrder(PmsProduct pmsProduct, PmsSkuStock pmsSkuStock, UmsMember umsMember, ApplyParam applyParam) {
        OmsOrder order = new OmsOrder();
        order.setMemberId(umsMember.getId());
        order.setMemberPhone(umsMember.getPhone());
        order.setMemberUsername(umsMember.getPhone());
        order.setCreateTime(new Date());
        order.setSignAmount(pmsSkuStock.getPrice());
        //TODO 前期免运费
        order.setFreightAmount(new BigDecimal(0));
        order.setPromotionAmount(pmsProduct.getFirstEachPriceSub());
        //TODO 前期不积分，后期开放
        order.setIntegrationAmount(new BigDecimal(0));
        order.setPayType(0);
        order.setSourceType(1);
        //设置收获信息
        UmsMemberReceiveAddress address = memberReceiveAddressMapper.selectByPrimaryKey(applyParam.getReceiverId());
        if(address == null) {
            throw new BusinessLogicException("无效收货人信息");
        }
        order.setReceiverName(address.getName());
        order.setReceiverPhone(address.getPhoneNumber());
        order.setReceiverCity(address.getCity());
        order.setReceiverDetailAddress(address.getDetailAddress());
        order.setReceiverPostCode(address.getPostCode());
        order.setReceiverProvince(address.getProvince());
        order.setReceiverRegion(address.getRegion());

        order.setIntegration(pmsProduct.getGiftPoint());
        order.setPromotionInfo(PromotionStatus.get(pmsProduct.getPromotionType()));
        order.setNote(applyParam.getNote());


        //设置价格，租期及其费用信息
        order.setSignAmount(pmsSkuStock.getPrice());
        order.setEachPrice(pmsSkuStock.getEachPrice());
        order.setPeriods(pmsProduct.getPeriod());
        order.setUnit(pmsProduct.getUnit());


        //如果是免押金产品，产品直接设置
        if(PromotionStatus.FREECHARGE.getStatus().equals(pmsProduct.getPromotionType())) {
            order.setFreeMoney(new BigDecimal(0));
            order.setPayAmount(new BigDecimal(0));
            //那么订单直接待审核
            order.setStatus(OrderStatus.WAITAUDIT.getStatus());
        }else{
            //优惠券抵扣金额
            if(applyParam.getCouponId() != null) {
                //查询该优惠券信息, 传递的couponID 为优惠券历史记录ID
                SmsCoupon coupon = couponHistoryDao.getCouponByHistoryId(applyParam.getCouponId());
                if(coupon == null) {
                    throw new BusinessLogicException("无效优惠券或已被使用");
                }
                order.setCouponAmount(coupon.getAmount());
                //如果产品未达到使用门槛，那么就无法使用该优惠券
                if(coupon.getMinPoint().compareTo(pmsSkuStock.getPrice()) <= 0) {
                    BigDecimal payAmount = umsMember.getFreeMoney().add(coupon.getAmount()).subtract(pmsSkuStock.getPrice());
                    if(payAmount.compareTo(new BigDecimal(0)) < 0) {
                        //客户额度不够支付，需要支付额外押金, 并优先扣除优惠券
                        //修改客户额度
                        insertFreeMoneyLog(umsMember.getFreeMoney(), umsMember);
                        umsMember.setFreeMoney(new BigDecimal(0));
                        order.setPayAmount(payAmount.abs());
                        order.setStatus(OrderStatus.PAY.getStatus());
                    } else {
                      //无需进行支付, 设置剩余额度
                      insertFreeMoneyLog(pmsSkuStock.getPrice().subtract(coupon.getAmount()), umsMember);
                      umsMember.setFreeMoney(payAmount);
                      order.setPayAmount(new BigDecimal(0));
                      order.setStatus(OrderStatus.WAITAUDIT.getStatus());
                    }
                    //设置优惠券ID
                    order.setCouponId(coupon.getId());
                    //设置优惠券被使用
                    SmsCouponHistory history = new SmsCouponHistory();
                    history.setUseStatus(1);
                    history.setId(applyParam.getCouponId());
                    couponHistoryMapper.updateByPrimaryKeySelective(history);
                }
            }else {
                //不使用优惠券场景
                if(umsMember.getFreeMoney() == null){
                    umsMember.setFreeMoney(new BigDecimal(0));
                }
                BigDecimal payAmount = umsMember.getFreeMoney().subtract(pmsSkuStock.getPrice());
                if(payAmount.compareTo(new BigDecimal(0)) < 0) {
                    insertFreeMoneyLog(umsMember.getFreeMoney(), umsMember);
                    umsMember.setFreeMoney(new BigDecimal(0));
                    order.setPayAmount(payAmount.abs());
                    order.setStatus(OrderStatus.PAY.getStatus());
                }else{
                    insertFreeMoneyLog(pmsSkuStock.getPrice(), umsMember);
                    umsMember.setFreeMoney(payAmount);
                    order.setPayAmount(new BigDecimal(0));
                    order.setStatus(OrderStatus.WAITAUDIT.getStatus());
                }
            }
        }
        //保存用户信息, 订单数据在签约之后在添加
        //umsMember.setOrderCount((umsMember.getOrderCount() == null ? 0 : umsMember.getOrderCount()) + 1);
        memberMapper.updateByPrimaryKeySelective(umsMember);
        order.setOrderSn(generateOrderSn(order));
        orderMapper.insertSelective(order);
        if(order.getPayAmount() != null && order.getPayAmount().intValue() > 0) {
            //待支付，加入到redis中， 用于后续超时取消订单
            redisService.setObj(WAITPAY + order.getId(), 1,
                    orderSettingMapper.selectByPrimaryKey(1L).getNormalOrderOvertime() * 60);
        }
        return order;
    }


    private void insertFreeMoneyLog(BigDecimal usedMoney, UmsMember umsMember) {
        UmsMemberFreemoneyLog log = new UmsMemberFreemoneyLog();
        log.setCreateTime(new Date());
        log.setMoney(usedMoney);
        log.setMemberId(umsMember.getId());
        log.setNote("支付押金");
        umsMemberFreemoneyLogMapper.insertSelective(log);
    }

    /**
     * 生成18位订单编号:8位日期+2位平台号码+2位支付方式+6位以上自增id
     */
    private String generateOrderSn(OmsOrder order) {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String key = REDIS_KEY_PREFIX_ORDER_ID + date;
        Long increment = redisService.increment(key, 1);
        sb.append(date);
        sb.append(String.format("%02d", order.getSourceType()));
        String incrementStr = increment.toString();
        if (incrementStr.length() <= 6) {
            sb.append(String.format("%06d", increment));
        } else {
            sb.append(incrementStr);
        }
        return sb.toString();
    }

    private SkuProps getEditAttrValue(PmsSkuStock skuStock, PmsProductAttribute attribute, int index) {
        SkuProps skuProps = new SkuProps();
        if(index == 0) {
            if(skuStock.getSp1() != null && attribute.getInputList().contains(skuStock.getSp1())) {
                skuProps.setName(attribute.getName());
                skuProps.setValue(skuStock.getSp1());
            }
        }else if(index == 1) {
            if(skuStock.getSp2() != null && attribute.getInputList().contains(skuStock.getSp2())) {
                skuProps.setName(attribute.getName());
                skuProps.setValue(skuStock.getSp2());
            }
        }else if(index == 2) {
            if(skuStock.getSp3() != null && attribute.getInputList().contains(skuStock.getSp3())) {
                skuProps.setName(attribute.getName());
                skuProps.setValue(skuStock.getSp3());
            }
        }
        return skuProps;
    }

    private OmsOrderItem createOrderItem(PmsProduct product, PmsSkuStock skuStock) {
        //创建订单产品项信息
        OmsOrderItem omsOrderItem = new OmsOrderItem();
        omsOrderItem.setProductId(product.getId());
        omsOrderItem.setProductPic(product.getPic());
        omsOrderItem.setProductName(product.getName());
        omsOrderItem.setProductSn(product.getProductSn());
        omsOrderItem.setProductPrice(skuStock.getPrice());
        omsOrderItem.setProductCostPrice(skuStock.getCostPrice());
        omsOrderItem.setProductSkuId(skuStock.getId());
        omsOrderItem.setProductSkuCode(skuStock.getSkuCode());
        omsOrderItem.setSp1(skuStock.getSp1());
        omsOrderItem.setSp2(skuStock.getSp2());
        omsOrderItem.setSp3(skuStock.getSp3());
        omsOrderItem.setProductEachPrice(skuStock.getEachPrice());
        omsOrderItem.setProductPeriods(product.getPeriod());
        omsOrderItem.setProductUnit(product.getUnit());
        //分解金额
        omsOrderItem.setGiftIntegration(product.getGiftPoint());
        //生成销售属性
        omsOrderItem.setProductAttr(createProductAttr(skuStock, product));
        omsOrderItem.setPromotionType(product.getPromotionType());
        omsOrderItem.setPromotionStartTime(product.getPromotionStartTime());
        omsOrderItem.setPromotionEndTime(product.getPromotionEndTime());
        omsOrderItem.setCreateTime(new Date());
        omsOrderItem.setFirstEachPriceSub(product.getFirstEachPriceSub());
        omsOrderItem.setProductCategoryId(product.getProductCategoryId());


        return omsOrderItem;
    }

    /**
     * 创建产品销售属性
     */
    private String createProductAttr(PmsSkuStock skuStock, PmsProduct pmsProduct) {
        List<SkuProps> skuPropsList = new ArrayList<>();
        //加载该产品具有的SKU名称
        PmsProductAttributeExample example = new PmsProductAttributeExample();
        //加载该类型下的所有SKU属性, 0->属性 2->参数
        example.createCriteria().andProductAttributeCategoryIdEqualTo(pmsProduct.getProductAttributeCategoryId()).andTypeEqualTo(0);
        List<PmsProductAttribute> attributeList = productAttributeMapper.selectByExample(example);

        for (int i = 0; i < attributeList.size(); i++) {
            PmsProductAttribute attribute = attributeList.get(i);
            if(Objects.equals(1, attribute.getHandAddStatus())) {
                //创建SKUProps
                String attrValue = getInputAttrValue(skuStock, i);
                if(!StringUtils.isEmpty(attrValue)) {
                    SkuProps skuProps = new SkuProps();
                    skuProps.setName(attribute.getName());
                    skuProps.setValue(attrValue);
                    skuPropsList.add(skuProps);
                }
            }else{
                //选中的属性
                SkuProps skuProps = getEditAttrValue(skuStock, attribute, i);
                if(skuProps != null) {
                    skuPropsList.add(skuProps);
                }
            }
        }
        return JSONUtil.toJsonStr(skuPropsList);
    }

    private String getInputAttrValue(PmsSkuStock skuStock, int index) {
        if(index == 0) {
            return skuStock.getSp1();
        }else if(index == 1) {
            return skuStock.getSp2();
        }else if(index == 2) {
            return skuStock.getSp3();
        }
        return "";
    }

    private String formatterUnit(Integer unit) {
        if (0 == unit) {
            return "日";
        } else if (1 == unit) {
            return "周";
        } else if (2 == unit) {
            return "月";
        } else if (3 == unit) {
            return "年";
        }
        return "月";
    }
}
