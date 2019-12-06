package com.xxz.rent.portal.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.github.pagehelper.PageHelper;
import com.xxz.rent.mapper.*;
import com.xxz.rent.model.*;
import com.xxz.rent.portal.dao.HomeDao;
import com.xxz.rent.portal.dao.PmsProductDao;
import com.xxz.rent.portal.dao.SmsHomeRecommendProductDao;
import com.xxz.rent.portal.dao.SmsHomeRecommendUsedProductDao;
import com.xxz.rent.portal.model.dto.HomeContentResult;
import com.xxz.rent.portal.model.dto.HomeFlashPromotion;
import com.xxz.rent.portal.model.dto.PmsProductResult;
import com.xxz.rent.portal.model.dto.SkuProps;
import com.xxz.rent.portal.service.HomeService;
import com.xxz.rent.portal.service.RedisService;
import com.xxz.rent.portal.service.UmsMemberService;
import com.xxz.rent.portal.util.DateUtil;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 首页内容管理Service实现类
 * Created by macro on 2019/1/28.
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private SmsHomeAdvertiseMapper advertiseMapper;
    @Autowired
    private HomeDao homeDao;
    @Autowired
    private SmsFlashPromotionMapper flashPromotionMapper;
    @Autowired
    private SmsFlashPromotionSessionMapper promotionSessionMapper;
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private PmsProductDao productDao;
    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;
    @Autowired
    private CmsSubjectMapper subjectMapper;
    @Autowired
    private SmsHomeRecommendProductDao recommendProductDao;
    @Autowired
    private SmsHomeRecommendUsedProductDao recommendUsedProductDao;
    @Autowired
    private PmsProductAttributeCategoryMapper productAttributeCategoryMapper;
    @Autowired
    private PmsProductAttributeMapper productAttributeMapper;
    @Autowired
    private PmsProductAttributeValueMapper productAttributeValueMapper;
    @Autowired
    private RedisService redisService;
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private UmsMemberBrewosProductMapper brewosProductMapper;


    private final String HOME_KEY = "portal:home";

    @Override
    public HomeContentResult content() {
        Object obj = redisService.getObj(HOME_KEY);
        if(obj != null) {
            return (HomeContentResult) obj;
        }
        HomeContentResult result = new HomeContentResult();
        //获取首页广告
        result.setAdvertiseList(getHomeAdvertiseList());
        //获取首页分类
        result.setCategoryList(getHomeCategoryList());
        //活动活动列表
        result.setActivityList(homeDao.getActivityList());
        //获取人气推荐
        result.setHotProductList(homeDao.getHotProductList(0,4));
        //获取精选二手
        result.setGoodUsedProductList(homeDao.getGoodUsedProductList(0, 4));
        //获取推荐专题
        result.setSubjectList(homeDao.getRecommendSubjectList(0,6));
        //保存到redis中30分钟
        redisService.setObj(HOME_KEY, result, 30 * 60);
        return result;
    }

    private List<PmsProductCategory> getHomeCategoryList() {
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        example.createCriteria().andShowStatusEqualTo(1).andNavStatusEqualTo(1).andLevelEqualTo(0);
        example.setOrderByClause("sort desc");
        List<PmsProductCategory> list = productCategoryMapper.selectByExample(example);
        return new ArrayList<>(CollectionUtil.sub(list, 0, 6));
    }

    @Override
    public List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return recommendUsedProductDao.recommendProductList();
    }

    @Override
    public List<PmsProductCategory> getProductCateList(Long parentId) {
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        example.createCriteria()
                .andShowStatusEqualTo(1)
                .andParentIdEqualTo(parentId);
        example.setOrderByClause("sort desc");
        List<PmsProductCategory> list = productCategoryMapper.selectByExample(example);
        //首页图标控制最多显示6个
        return CollectionUtil.sub(list, 0, 6);
    }

    @Override
    public List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        CmsSubjectExample example = new CmsSubjectExample();
        CmsSubjectExample.Criteria criteria = example.createCriteria();
        criteria.andShowStatusEqualTo(1);
        return subjectMapper.selectByExample(example);
    }

    @Override
    public List<PmsProduct> goodUsedProductList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageSize, pageNum);
        return recommendProductDao.goodUsedProductList();
    }

    @Override
    public List<PmsProduct> productList(Long id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andProductCategoryIdEqualTo(id)
            .andDeleteStatusEqualTo(0).andPublishStatusEqualTo(1);
        return productMapper.selectByExample(example);
    }

    @Override
    public List<PmsProduct> getPorductListBySubjectId(Long id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return homeDao.getPorductListBySubjectId(id);
    }

    @Override
    public PmsProductResult getProductDetail(Long id) {
        PmsProductResult productResult = productDao.getProductDetail(id);
        List<SkuProps> skuPropsList = new ArrayList<>();
        //加载该产品具有的SKU名称
        PmsProductAttributeExample example = new PmsProductAttributeExample();
        //加载该类型下的所有SKU属性, 0->属性 2->参数
        example.createCriteria().andProductAttributeCategoryIdEqualTo(productResult.getProductAttributeCategoryId()).andTypeEqualTo(0);
        List<PmsProductAttribute> attributeList = productAttributeMapper.selectByExample(example);

        for (int i = 0; i < attributeList.size(); i++) {
            PmsProductAttribute attribute = attributeList.get(i);
            if(Objects.equals(1, attribute.getHandAddStatus())) {
                //加载该属性集合
                PmsProductAttributeValueExample valueExample = new PmsProductAttributeValueExample();
                valueExample.createCriteria().andProductAttributeIdEqualTo(attribute.getId()).andProductIdEqualTo(id);
                List<PmsProductAttributeValue> attributeValues = productAttributeValueMapper.selectByExample(valueExample);
                if(attributeValues.size() > 0) {
                    //创建SKUProps
                    SkuProps skuProps = new SkuProps();
                    skuProps.setName(attribute.getName());
                    skuProps.setValue(attributeValues.get(0).getValue());
                    skuPropsList.add(skuProps);
                }
            }else{
                //选中的属性
                SkuProps skuProps = getEditAttrValue(productResult.getPmsSkuStockList(), attribute, i);
                if(skuProps != null) {
                    skuPropsList.add(skuProps);
                }
            }
        }
        productResult.setSkuPropsList(skuPropsList);

        //加入浏览记录
        if(memberService.getCurrentMember() != null) {
            brewosProduct(id, memberService.getCurrentMember().getId());
        }
        return productResult;
    }

    /**
     * 插入浏览记录
     * @param productId
     * @param memberId
     */
    private void brewosProduct(Long productId, Long memberId) {
        UmsMemberBrewosProduct brewosProduct = new UmsMemberBrewosProduct();
        brewosProduct.setMemberId(memberId);
        brewosProduct.setProductId(productId);
        brewosProduct.setType(1);
        brewosProduct.setCreateTime(new Date());
        brewosProduct.setCreateDate(cn.hutool.core.date.DateUtil.formatDate(new Date()));
        brewosProductMapper.insertSelective(brewosProduct);
    }

    private SkuProps getEditAttrValue(List<PmsSkuStock> skuStockList, PmsProductAttribute attribute, int index) {
        SkuProps skuProps = new SkuProps();
        List<String> values = new ArrayList<>();
        if(index == 0) {
            for (int i = 0; i < skuStockList.size(); i++) {
                PmsSkuStock skuStock = skuStockList.get(i);
                if(skuStock.getSp1() != null && attribute.getInputList().contains(skuStock.getSp1())) {
                       skuProps.setName(attribute.getName());
                       if(!values.contains(skuStock.getSp1())) {
                           values.add(skuStock.getSp1());
                       }
                }
            }
        }else if(index == 1) {
            for (int i = 0; i < skuStockList.size(); i++) {
                PmsSkuStock skuStock = skuStockList.get(i);
                if(skuStock.getSp2() != null && attribute.getInputList().contains(skuStock.getSp2())) {
                    skuProps.setName(attribute.getName());
                    if(!values.contains(skuStock.getSp2())) {
                        values.add(skuStock.getSp2());
                    }
                }
            }
        }else if(index == 2) {
            for (int i = 0; i < skuStockList.size(); i++) {
                PmsSkuStock skuStock = skuStockList.get(i);
                if(skuStock.getSp3() != null && attribute.getInputList().contains(skuStock.getSp3())) {
                    skuProps.setName(attribute.getName());
                    if(!values.contains(skuStock.getSp3())) {
                        values.add(skuStock.getSp3());
                    }
                }
            }
        }
        if(values.size() == 0) {
            return null;
        }
        skuProps.setValue(StringUtils.join(values, ","));
        return skuProps;
    }


    private HomeFlashPromotion getHomeFlashPromotion() {
        HomeFlashPromotion homeFlashPromotion = new HomeFlashPromotion();
        //获取当前秒杀活动
        Date now = new Date();
        SmsFlashPromotion flashPromotion = getFlashPromotion(now);
        if (flashPromotion != null) {
            //获取当前秒杀场次
            SmsFlashPromotionSession flashPromotionSession = getFlashPromotionSession(now);
            if (flashPromotionSession != null) {
                homeFlashPromotion.setStartTime(flashPromotionSession.getStartTime());
                homeFlashPromotion.setEndTime(flashPromotionSession.getEndTime());
                //获取下一个秒杀场次
                SmsFlashPromotionSession nextSession = getNextFlashPromotionSession(homeFlashPromotion.getStartTime());
                if(nextSession!=null){
                    homeFlashPromotion.setNextStartTime(nextSession.getStartTime());
                    homeFlashPromotion.setNextEndTime(nextSession.getEndTime());
                }
                //获取秒杀商品
//                List<FlashPromotionProduct> flashProductList = homeDao.getFlashProductList(flashPromotion.getId(), flashPromotionSession.getId());
//                homeFlashPromotion.setProductList(flashProductList);
            }
        }
        return homeFlashPromotion;
    }

    //获取下一个场次信息
    private SmsFlashPromotionSession getNextFlashPromotionSession(Date date) {
        SmsFlashPromotionSessionExample sessionExample = new SmsFlashPromotionSessionExample();
        sessionExample.createCriteria()
                .andStartTimeGreaterThan(date);
        sessionExample.setOrderByClause("start_time asc");
        List<SmsFlashPromotionSession> promotionSessionList = promotionSessionMapper.selectByExample(sessionExample);
        if (!CollectionUtils.isEmpty(promotionSessionList)) {
            return promotionSessionList.get(0);
        }
        return null;
    }

    private List<SmsHomeAdvertise> getHomeAdvertiseList() {
        SmsHomeAdvertiseExample example = new SmsHomeAdvertiseExample();
        example.createCriteria().andTypeEqualTo(1).andStatusEqualTo(1);
        example.setOrderByClause("sort desc");
        return advertiseMapper.selectByExample(example);
    }

    //根据时间获取秒杀活动
    private SmsFlashPromotion getFlashPromotion(Date date) {
        Date currDate = DateUtil.getDate(date);
        SmsFlashPromotionExample example = new SmsFlashPromotionExample();
        example.createCriteria()
                .andStatusEqualTo(1)
                .andStartDateLessThanOrEqualTo(currDate)
                .andEndDateGreaterThanOrEqualTo(currDate);
        List<SmsFlashPromotion> flashPromotionList = flashPromotionMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(flashPromotionList)) {
            return flashPromotionList.get(0);
        }
        return null;
    }

    //根据时间获取秒杀场次
    private SmsFlashPromotionSession getFlashPromotionSession(Date date) {
        Date currTime = DateUtil.getTime(date);
        SmsFlashPromotionSessionExample sessionExample = new SmsFlashPromotionSessionExample();
        sessionExample.createCriteria()
                .andStartTimeLessThanOrEqualTo(currTime)
                .andEndTimeGreaterThanOrEqualTo(currTime);
        List<SmsFlashPromotionSession> promotionSessionList = promotionSessionMapper.selectByExample(sessionExample);
        if (!CollectionUtils.isEmpty(promotionSessionList)) {
            return promotionSessionList.get(0);
        }
        return null;
    }
}
