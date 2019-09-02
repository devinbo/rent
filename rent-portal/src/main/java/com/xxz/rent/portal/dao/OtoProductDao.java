package com.xxz.rent.portal.dao;

import com.xxz.rent.model.OtoProductReply;
import com.xxz.rent.portal.model.dto.OtoCommentResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xxz
 */
public interface OtoProductDao {

    /**  功能描述 <br>
     * <查询留言信息>
     *
     * @param productId
     * @return java.util.List<com.xxz.rent.portal.model.dto.OtoCommentResult>
     * @date 2019-08-02 18:04
     */
    List<OtoCommentResult> commentList(@Param("productId") Long productId);


    List<OtoProductReply> replyList();
}
