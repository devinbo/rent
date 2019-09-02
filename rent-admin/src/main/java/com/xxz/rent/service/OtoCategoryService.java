package com.xxz.rent.service;


import com.xxz.rent.dto.PageParam;
import com.xxz.rent.model.OtoProductCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xxz
 */
@Transactional
public interface OtoCategoryService {
    /**  功能描述 <br>
     * <分类查询分类列表>
     *
     * @param name
     * @param pageParam
     * @return java.util.List<com.xxz.rent.model.OtoProductCategory>
     * @date 2019-08-02 10:50
     */
    List<OtoProductCategory> list(String name, PageParam pageParam);

    /**  功能描述 <br>
     * <创建>
     *
     * @param otoProductCategory
     * @return int
     * @date 2019-08-02 11:18
     */
    int create(OtoProductCategory otoProductCategory);

    /**  功能描述 <br>
     * <修改>
     *
     * @param id
     * @param otoProductCategory
     * @return int
     * @date 2019-08-02 11:19
     */
    int update(Long id, OtoProductCategory otoProductCategory);

    /**  功能描述 <br>
     * <删除>
     *
     * @param id
     * @return int
     * @date 2019-08-02 11:20
     */
    int delete(Long id);
}
