package com.xxz.rent.portal.model.dto;

import com.xxz.rent.model.OmsCartItem;

import java.math.BigDecimal;

/**
 * Created by macro on 2018/8/27.
 * 购物车中促销信息的封装
 */
public class CartPromotionItem extends OmsCartItem{
    //促销活动信息
    private String promotionMessage;
    //促销活动减去的金额，针对每
    //商品的真实库存（剩余库存-
    //购买商品赠送积分
    private Integer integration;
    //购买商品
    public String getPromotionMessage() {
        return promotionMessage;
    }

    public void setPromotionMessage(String promotionMessage) {
        this.promotionMessage = promotionMessage;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

}
