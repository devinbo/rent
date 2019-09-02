package com.xxz.rent.portal.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.xxz.rent.dto.enumerate.OtoProductStatus;
import com.xxz.rent.dto.enumerate.RentUnit;
import com.xxz.rent.mapper.*;
import com.xxz.rent.model.*;
import com.xxz.rent.portal.bo.exception.BusinessLogicException;
import com.xxz.rent.portal.dao.OtoProductDao;
import com.xxz.rent.portal.model.dto.*;
import com.xxz.rent.portal.service.OssService;
import com.xxz.rent.portal.service.OtoProductService;
import com.xxz.rent.portal.service.UmsMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-02 14:10
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Service
@Slf4j
public class OtoProductServiceImpl implements OtoProductService {

    @Autowired
    private OssService ossService;
    @Autowired
    private OtoProductMapper productMapper;
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private UmsMemberMapper memberMapper;
    @Autowired
    private OtoProductDao productDao;
    @Autowired
    private OtoProductCategoryMapper productCategoryMapper;
    @Autowired
    private OtoProductCommentMapper otoProductCommentMapper;
    @Autowired
    private OtoProductReplyMapper otoProductReplyMapper;


    @Override
    public int add(MultipartFile[] pic, OtoProductParam productParam) {
        OtoProduct otoProduct = new OtoProduct();
        //判断最短起租数是否小于最迟归还的日期
        Integer unit = productParam.getRentUnit();
        String rentLatest = productParam.getRentLatest();
        Date latestDate = DateUtil.parse(rentLatest);
        if (unit == RentUnit.DAY.getValue()) {
            long betweenDay = DateUtil.betweenDay(new Date(), latestDate, false);
            if (betweenDay < productParam.getRentLeastNum()) {
                throw new BusinessLogicException("最迟归还日期不能小于最短最期数对应的日期");
            }
        } else if (unit == RentUnit.WEEK.getValue()) {
            long betweenDay = DateUtil.betweenDay(new Date(), latestDate, false);
            int len = (int) betweenDay / 7;
            if (len < productParam.getRentLeastNum()) {
                throw new BusinessLogicException("最迟归还日期不能小于最短最期数对应的日期");
            }
        } else if (unit == RentUnit.MONTH.getValue()) {
            long betweenMonth = DateUtil.betweenMonth(new Date(), latestDate, false);
            if (betweenMonth < productParam.getRentLeastNum()) {
                throw new BusinessLogicException("最迟归还日期不能小于最短最期数对应的日期");
            }
        } else if (unit == RentUnit.YEAR.getValue()) {
            long betweenYear = DateUtil.betweenYear(new Date(), latestDate, false);
            if (betweenYear < productParam.getRentLeastNum()) {
                throw new BusinessLogicException("最迟归还日期不能小于最短最期数对应的日期");
            }
        }

        //处理图片，获取图片路径
        try {
            String picUrl = uploadOssPics(pic);
            otoProduct.setAlbumPics(picUrl);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new BusinessLogicException("服务异常，图片上传失败！");
        }
        BeanUtil.copyProperties(productParam, otoProduct);

        otoProduct.setCreateTime(new Date());
        otoProduct.setStatus(OtoProductStatus.AUDIT.getStatus());
        otoProduct.setDeleteStatus(0);
        otoProduct.setRentLatestDate(DateUtil.parseDate(productParam.getRentLatest()));

        //设置首页图片， 首页图片为上传的第一个
        String firstPic = otoProduct.getAlbumPics().split(",")[0];
        otoProduct.setPic(firstPic);
        otoProduct.setMemberId(memberService.getCurrentMember().getId());
        int count = productMapper.insertSelective(otoProduct);

        //todo 通知审核员
        return count;
    }


    @Override
    public OtoProductResult get(Long id) {
        OtoProductResult result = new OtoProductResult();
        //加载产品信息
        OtoProduct otoProduct = productMapper.selectByPrimaryKey(id);
        if(otoProduct == null) {
            throw new BusinessLogicException("无效ID");
        }
        result.setProduct(otoProduct);

        //加载用户信息
        UmsMember member = memberMapper.selectByPrimaryKey(otoProduct.getMemberId());
        UmsMemberPublishResult memberPublishResult = new UmsMemberPublishResult();
        BeanUtil.copyProperties(member, memberPublishResult);
        if (memberPublishResult.getRentCount() == null) {
            memberPublishResult.setRentCount(0);
        } else if (memberPublishResult.getRentCount() > 0) {
            //历史不包含当前
            memberPublishResult.setRentCount(memberPublishResult.getRentCount());
        }
        result.setMember(memberPublishResult);

        //加载最新10条评论信息
        List<OtoCommentResult> commentResultList = commentList(id, 1, 10);
        result.setCommentList(commentResultList);

        //添加浏览量
        OtoProduct product = new OtoProduct();
        product.setId(id);
        product.setViewNum((otoProduct.getViewNum() == null ? 0 : otoProduct.getViewNum()) + 1);
        productMapper.updateByPrimaryKeySelective(product);
        return result;
    }

    @Override
    public List<OtoProductCategory> getAllProdCate() {
        OtoProductCategoryExample example = new OtoProductCategoryExample();
        example.createCriteria().andShowStatusEqualTo(1);
        return productCategoryMapper.selectByExample(example);
    }

    @Override
    public int comment(CommentParam commentParam) {
        UmsMember currMember = memberService.getCurrentMemberByDb();
        OtoProductComment comment = new OtoProductComment();
        comment.setContent(commentParam.getContent());
        comment.setCreateTime(new Date());
        comment.setMemberId(currMember.getId());
        comment.setMemberNickname(currMember.getNickname());
        comment.setMemberPic(currMember.getIcon());
        comment.setProductId(commentParam.getProductId());
        int count = otoProductCommentMapper.insertSelective(comment);
        //添加留言次数
        OtoProduct otoProduct = productMapper.selectByPrimaryKey(commentParam.getProductId());
        otoProduct.setLeaveNum(otoProduct.getLeaveNum() == null ? 1 : otoProduct.getLeaveNum() + 1);
        productMapper.updateByPrimaryKeySelective(otoProduct);
        return count;
    }

    @Override
    public int reply(ReplyParam replyParam) {
        UmsMember currMember = memberService.getCurrentMemberByDb();
        OtoProductReply reply = new OtoProductReply();

        reply.setCommentId(replyParam.getCommentId());
        reply.setContent(replyParam.getContent());
        reply.setReplyType(replyParam.getReplyType());
        reply.setMemberId(currMember.getId());
        reply.setMemberNickname(currMember.getNickname());
        reply.setMemberPic(currMember.getIcon());

        //设置被回复者信息
        UmsMember toMember = memberMapper.selectByPrimaryKey(replyParam.getToMemberId());
        if (toMember == null) {
            throw new BusinessLogicException("被回复者信息不存在");
        }
        reply.setToMemberId(toMember.getId());
        reply.setToMemberNickname(toMember.getNickname());
        reply.setToMemberPic(toMember.getIcon());
        reply.setCreateTime(new Date());

        return otoProductReplyMapper.insertSelective(reply);
    }

    @Override
    public List<OtoCommentResult> commentList(Long productId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("create_time desc");
        return productDao.commentList(productId);
    }

    @Override
    public OtoPreOrderResult preApply(Long id) {
        OtoPreOrderResult otoPreOrderResult = new OtoPreOrderResult();
        OtoProduct otoProduct = productMapper.selectByPrimaryKey(id);
        BeanUtil.copyProperties(otoProduct, otoPreOrderResult);
        BigDecimal productPrice = otoProduct.getProductPrice() == null ? new BigDecimal(0) : otoProduct.getProductPrice();
        UmsMember member = memberService.getCurrentMemberByDb();
        BigDecimal freeMoney = member.getFreeMoney() == null ? new BigDecimal(0) : member.getFreeMoney();
        if (freeMoney.compareTo(productPrice) >= 0) {
            //说明会员额度够扣减，无需进行支付
            otoPreOrderResult.setPayMoney(new BigDecimal(0));
        } else {
            otoPreOrderResult.setPayMoney(productPrice.subtract(freeMoney));
        }

        /*设置最短，最长租期**/

        //最短起租数
        Integer rentLeastNum = otoProduct.getRentLeastNum() != null ? otoProduct.getRentLeastNum() : 0;

        otoPreOrderResult.setMinPeriod(Long.valueOf(rentLeastNum));
        //根据最迟归还日期，
        Date latestDate = otoProduct.getRentLatestDate();
        Date nowDate = new Date();
        if (otoProduct.getRentUnit() == RentUnit.DAY.getValue()) {
            long betweenDay = DateUtil.betweenDay(nowDate, latestDate, true);
            //最大起租数需大于最短起租数， 否则不设置最大起租数
            if (betweenDay > rentLeastNum) {
                otoPreOrderResult.setMaxPeriod(betweenDay);
            }
        } else if (otoProduct.getRentUnit() == RentUnit.WEEK.getValue()) {
            long betweenDay = DateUtil.betweenDay(nowDate, latestDate, true);
            if ((int) betweenDay / 7 > rentLeastNum) {
                otoPreOrderResult.setMaxPeriod(betweenDay / 7);
            }
        } else if(otoProduct.getRentUnit() == RentUnit.MONTH.getValue()) {
            long betweenMonth = DateUtil.betweenMonth(nowDate, latestDate, true);
            if (betweenMonth > rentLeastNum) {
                otoPreOrderResult.setMaxPeriod(betweenMonth);
            }
        } else if(otoProduct.getRentUnit() == RentUnit.YEAR.getValue()) {
            long betweenYear = DateUtil.betweenYear(nowDate, latestDate, true);
            if (betweenYear > rentLeastNum) {
                otoPreOrderResult.setMaxPeriod(betweenYear);
            }
        }
        return otoPreOrderResult;
    }

    @Override
    public List<OtoProductReply> replyList(Long id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("create_time desc");
        OtoProductReplyExample example = new OtoProductReplyExample();
        example.createCriteria().andCommentIdEqualTo(id);
        return otoProductReplyMapper.selectByExample(example);
    }


    private String uploadOssPics(MultipartFile[] pics) throws IOException {
        List<String> list = new ArrayList<>();
        for (MultipartFile pic : pics) {
            String url = ossService.uploadWithFile(pic);
            list.add(url);
        }
        return CollectionUtil.join(list.iterator(), ",");
    }


}
