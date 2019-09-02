package com.xxz.rent.dao;

import com.xxz.rent.dto.OtoCommentResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-08-09 17:22
 * @description：
 * @modified By：
 * @version: ：1.0
 */
public interface OtoProductDao {

    List<OtoCommentResult> commentList(@Param("productId") Long productId);
}
