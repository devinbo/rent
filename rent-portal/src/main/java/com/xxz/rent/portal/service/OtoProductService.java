package com.xxz.rent.portal.service;

import com.xxz.rent.model.OtoProductCategory;
import com.xxz.rent.model.OtoProductReply;
import com.xxz.rent.portal.model.dto.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author xxz
 */
public interface OtoProductService {

    /**  功能描述 <br>
     * <产品信息>
     *
     *
     * @param pic
     * @param productParam
     * @return int
     * @date 2019-08-02 14:09
     */
    int add(MultipartFile[] pic, OtoProductParam productParam);

    /**  功能描述 <br>
     * <查询某一产品详情>
     *
     * @param id
     * @return com.xxz.rent.portal.model.dto.OtoProductResult
     * @date 2019-08-02 14:58
     */
    OtoProductResult get(Long id);

    /**  功能描述 <br>
     * <查询所有产品分类信息>
     *
     * @param
     * @return java.util.List<com.xxz.rent.model.OtoProductCategory>
     * @date 2019-08-02 16:04
     */
    List<OtoProductCategory> getAllProdCate();

    /**  功能描述 <br>
     * <留言>
     *
     * @param commentParam
     * @return int
     * @date 2019-08-02 16:14
     */
    int comment(CommentParam commentParam);

    /**  功能描述 <br>
     * <回复>
     *
     * @param replyParam
     * @return int
     * @date 2019-08-02 17:09
     */
    int reply(ReplyParam replyParam);

    /**  功能描述 <br>
     * <留言列表>
     *
     * @param productId
     * @param pageNum
     * @param pageSize
     * @return java.util.List<com.xxz.rent.portal.model.dto.OtoCommentResult>
     * @date 2019-08-02 17:50
     */
    List<OtoCommentResult> commentList(Long productId, Integer pageNum, Integer pageSize);

    /**  功能描述 <br>
     * <预申请>
     *
     * @param id
     * @return com.xxz.rent.portal.model.dto.OtoPreOrderResult
     * @date 2019-08-09 10:25
     */
    OtoPreOrderResult preApply(Long id);

    List<OtoProductReply> replyList(Long id, Integer pageNum, Integer pageSize);

}
