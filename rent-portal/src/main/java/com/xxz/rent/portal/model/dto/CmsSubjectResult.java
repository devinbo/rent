package com.xxz.rent.portal.model.dto;

import com.xxz.rent.model.CmsSubject;
import com.xxz.rent.model.PmsProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-23 15:03
 * @description：
 * @modified By：
 * @version: ：1.0
 */
public class CmsSubjectResult extends CmsSubject {

    @Getter
    @Setter
    private List<PmsProduct> productList;
}
