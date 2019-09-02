package com.xxz.rent.portal.service;

import com.xxz.rent.model.OtoOrderPayment;
import com.xxz.rent.model.OtoProduct;
import com.xxz.rent.model.OtoSite;
import com.xxz.rent.portal.model.dto.PublishDetailResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xxz
 */
@Transactional
public interface OtoPublishService {

    /**  功能描述 <br>
     * <查询发布列表>
     *
     * @param status
     * @param pageNum
     * @param pageSize
     * @return java.util.List<com.xxz.rent.model.OtoProduct>
     * @date 2019-08-15 13:54
     */
    List<OtoProduct> list(Integer status, int pageNum, int pageSize);

    /**
     * 下架发布信息
     * @param id
     * @return
     */
    int soldOut(Long id);

    /**
     * 删除发布信息
     * @param id
     * @return
     */
    int delete(Long id);

    /**  功能描述 <br>
     * <详细>
     *
     * @param id
     * @return com.xxz.rent.portal.model.dto.PublishDetailResult
     * @date 2019-08-15 14:23
     */
    PublishDetailResult detail(Long id);

    List<OtoSite> agencyList(String key, String city);

    List<OtoOrderPayment> rentDetail(Long id);
}
