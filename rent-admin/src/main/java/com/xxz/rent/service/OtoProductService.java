package com.xxz.rent.service;

import com.xxz.rent.dto.OtoCommentResult;
import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.OtoProduct;
import com.xxz.rent.model.OtoProductReply;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author xxz
 */
@Transactional
public interface OtoProductService {
    /**  功能描述 <br>
     * <分类查询信息列表>
     *
     * @param name
     * @param status
     * @param pageParam
     * @return java.util.List<com.xxz.rent.model.OtoProduct>
     * @date 2019-08-06 11:32
     */
    List<OtoProduct> list(String name, String[] startTime, Integer status, PageParam pageParam);

    /**  功能描述 <br>
     * <加载发布产品信息>
     *
     * @param id
     * @return com.xxz.rent.model.OtoProduct
     * @date 2019-08-06 14:00
     */
    OtoProduct get(Long id);

    int updatePrice(Long id, BigDecimal productPrice);

    int audit(Long id, Integer status, String refuseReason, Integer goodStatus, Integer reliableStatus);

    List<OtoCommentResult> commentList(Long productId, Integer pageNum, Integer pageSize);

    List<OtoProductReply> replyList(Long id, Integer pageNum, Integer pageSize);
}
