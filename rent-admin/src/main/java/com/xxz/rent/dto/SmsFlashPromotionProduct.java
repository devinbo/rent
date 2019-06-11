package com.xxz.rent.dto;

import com.xxz.rent.model.PmsProduct;
import com.xxz.rent.model.SmsFlashPromotionProductRelation;
import com.xxz.rent.model.PmsProduct;
import com.xxz.rent.model.SmsFlashPromotionProductRelation;
import lombok.Getter;
import lombok.Setter;

/**
 * 限时购及商品信息封装
 * Created by macro on 2018/11/16.
 */
public class SmsFlashPromotionProduct extends SmsFlashPromotionProductRelation {
    @Getter
    @Setter
    private PmsProduct product;
}
