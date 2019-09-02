package com.xxz.rent.portal.model.dto;

import com.xxz.rent.model.OtoProductComment;
import com.xxz.rent.model.OtoProductReply;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-02 15:46
 * @description：评论信息
 * @modified By：
 * @version: ：1.0
 */
public class OtoCommentResult extends OtoProductComment {

    @Setter
    @Getter
    private List<OtoProductReply> replyList;

}
