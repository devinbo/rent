package com.xxz.rent.dto;

import com.xxz.rent.model.CmsSubject;
import com.xxz.rent.model.CmsSubjectProductRelation;
import com.xxz.rent.model.PmsProduct;
import lombok.Data;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-06 10:08
 * @description：专题信息封装，包括绑定商品
 * @modified By：
 * @version: ：1.0
 */
@Data
public class CmsSubjectResult extends CmsSubject {

    /**
     * 绑定的商品
     */
    private List<PmsProduct> productList;

}
