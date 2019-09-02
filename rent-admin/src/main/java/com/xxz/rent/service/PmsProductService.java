package com.xxz.rent.service;

import com.xxz.rent.dto.PageParam;
import com.xxz.rent.dto.PmsProductParam;
import com.xxz.rent.dto.PmsProductQueryParam;
import com.xxz.rent.dto.PmsProductResult;
import com.xxz.rent.model.PmsProduct;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品管理Service
 *
 * @author xxz
 */
public interface PmsProductService {
    /**
     * 创建商品
     */
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    int create(PmsProductParam productParam);

    /**
     * 根据商品编号获取更新信息
     */
    PmsProductResult getUpdateInfo(Long id);

    /**
     * 更新商品
     */
    @Transactional
    int update(Long id, PmsProductParam productParam);

    /**
     * 分页查询商品
     */
    List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量修改审核状态
     * @param ids 产品id
     * @param verifyStatus 审核状态
     * @param detail 审核详情
     */
    @Transactional
    int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);

    /**
     * 批量修改商品上架状态
     */
    int updatePublishStatus(List<Long> ids, Integer publishStatus);

    /**
     * 批量修改商品推荐状态
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 批量修改新品状态
     */
    int updateNewStatus(List<Long> ids, Integer newStatus);

    /**
     * 批量删除商品
     */
    int updateDeleteStatus(List<Long> ids, Integer deleteStatus);

    /**
     * 根据商品名称或者货号模糊查询
     */
    List<PmsProduct> list(String keyword);


    /**  功能描述 <br>
     * <根据分类信息查询订单信息>
     *
     * @param cateId
     * @param pageParam
     * @return java.util.List<com.xxz.rent.model.PmsProduct>
     * @date 2019-07-06 14:25
     */
    List<PmsProduct> getProductByCateId(Long cateId, PageParam pageParam);

    /**  功能描述 <br>
     * <修改产品分类信息>
     *
     * @param id
     * @param pmsProduct
     * @return int
     * @date 2019-07-06 18:00
     */
    int updateCate(Long id, PmsProduct pmsProduct);

    /**  功能描述 <br>
     * <移除产品到分类信息>
     *
     * @param id
     * @return int
     * @date 2019-07-06 18:31
     */
    int deleteCate(Long id);

    /**  功能描述 <br>
     * <分页加载二手商品>
     *
     * @param pageParam
     * @return java.util.List<com.xxz.rent.model.PmsProduct>
     * @date 2019-07-08 20:59
     */
    List<PmsProduct> getUsedList(PageParam pageParam);
}
