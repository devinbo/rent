package com.xxz.rent.service;

import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.UmsMemberOperation;

import java.util.List;

/**
 * @author xxz
 */
public interface UmsMemberOperationService {
    /**  功能描述 <br>
     * <分页查询会员资料操作记录>
     *
     * @param memberId
     * @param pageParam
     * @return java.util.List<com.xxz.rent.model.UmsMemberOperation>
     * @date 2019-06-28 10:52
     */
    List<UmsMemberOperation> list(Long memberId, PageParam pageParam);
}
