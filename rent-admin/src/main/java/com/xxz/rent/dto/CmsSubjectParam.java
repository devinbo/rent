package com.xxz.rent.dto;

import com.xxz.rent.model.CmsSubject;
import com.xxz.rent.model.CmsSubjectProductRelation;
import lombok.Data;

import java.util.List;

/**
 * @author ：xhb
 * @date ：Created in 2019-07-06 11:01
 * @description：
 * @modified By：
 * @version: ：1.0
 */
@Data
public class CmsSubjectParam extends CmsSubject {

    private List<CmsSubjectProductRelation> productRelationList;
}
