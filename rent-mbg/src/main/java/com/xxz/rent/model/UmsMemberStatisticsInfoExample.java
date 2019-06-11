package com.xxz.rent.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UmsMemberStatisticsInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UmsMemberStatisticsInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Long value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Long value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Long value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Long value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Long> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Long> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Long value1, Long value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountIsNull() {
            addCriterion("consume_amount is null");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountIsNotNull() {
            addCriterion("consume_amount is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountEqualTo(BigDecimal value) {
            addCriterion("consume_amount =", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountNotEqualTo(BigDecimal value) {
            addCriterion("consume_amount <>", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountGreaterThan(BigDecimal value) {
            addCriterion("consume_amount >", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("consume_amount >=", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountLessThan(BigDecimal value) {
            addCriterion("consume_amount <", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("consume_amount <=", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountIn(List<BigDecimal> values) {
            addCriterion("consume_amount in", values, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountNotIn(List<BigDecimal> values) {
            addCriterion("consume_amount not in", values, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consume_amount between", value1, value2, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consume_amount not between", value1, value2, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andOrderCountIsNull() {
            addCriterion("order_count is null");
            return (Criteria) this;
        }

        public Criteria andOrderCountIsNotNull() {
            addCriterion("order_count is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCountEqualTo(Integer value) {
            addCriterion("order_count =", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotEqualTo(Integer value) {
            addCriterion("order_count <>", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountGreaterThan(Integer value) {
            addCriterion("order_count >", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_count >=", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountLessThan(Integer value) {
            addCriterion("order_count <", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountLessThanOrEqualTo(Integer value) {
            addCriterion("order_count <=", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountIn(List<Integer> values) {
            addCriterion("order_count in", values, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotIn(List<Integer> values) {
            addCriterion("order_count not in", values, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountBetween(Integer value1, Integer value2) {
            addCriterion("order_count between", value1, value2, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_count not between", value1, value2, "orderCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountIsNull() {
            addCriterion("coupon_count is null");
            return (Criteria) this;
        }

        public Criteria andCouponCountIsNotNull() {
            addCriterion("coupon_count is not null");
            return (Criteria) this;
        }

        public Criteria andCouponCountEqualTo(Integer value) {
            addCriterion("coupon_count =", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountNotEqualTo(Integer value) {
            addCriterion("coupon_count <>", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountGreaterThan(Integer value) {
            addCriterion("coupon_count >", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_count >=", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountLessThan(Integer value) {
            addCriterion("coupon_count <", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_count <=", value, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountIn(List<Integer> values) {
            addCriterion("coupon_count in", values, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountNotIn(List<Integer> values) {
            addCriterion("coupon_count not in", values, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountBetween(Integer value1, Integer value2) {
            addCriterion("coupon_count between", value1, value2, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCouponCountNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_count not between", value1, value2, "couponCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNull() {
            addCriterion("comment_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNotNull() {
            addCriterion("comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountEqualTo(Integer value) {
            addCriterion("comment_count =", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotEqualTo(Integer value) {
            addCriterion("comment_count <>", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThan(Integer value) {
            addCriterion("comment_count >", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_count >=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThan(Integer value) {
            addCriterion("comment_count <", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThanOrEqualTo(Integer value) {
            addCriterion("comment_count <=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIn(List<Integer> values) {
            addCriterion("comment_count in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotIn(List<Integer> values) {
            addCriterion("comment_count not in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountBetween(Integer value1, Integer value2) {
            addCriterion("comment_count between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_count not between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountIsNull() {
            addCriterion("login_count is null");
            return (Criteria) this;
        }

        public Criteria andLoginCountIsNotNull() {
            addCriterion("login_count is not null");
            return (Criteria) this;
        }

        public Criteria andLoginCountEqualTo(Integer value) {
            addCriterion("login_count =", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountNotEqualTo(Integer value) {
            addCriterion("login_count <>", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountGreaterThan(Integer value) {
            addCriterion("login_count >", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_count >=", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountLessThan(Integer value) {
            addCriterion("login_count <", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountLessThanOrEqualTo(Integer value) {
            addCriterion("login_count <=", value, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountIn(List<Integer> values) {
            addCriterion("login_count in", values, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountNotIn(List<Integer> values) {
            addCriterion("login_count not in", values, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountBetween(Integer value1, Integer value2) {
            addCriterion("login_count between", value1, value2, "loginCount");
            return (Criteria) this;
        }

        public Criteria andLoginCountNotBetween(Integer value1, Integer value2) {
            addCriterion("login_count not between", value1, value2, "loginCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountIsNull() {
            addCriterion("attend_count is null");
            return (Criteria) this;
        }

        public Criteria andAttendCountIsNotNull() {
            addCriterion("attend_count is not null");
            return (Criteria) this;
        }

        public Criteria andAttendCountEqualTo(Integer value) {
            addCriterion("attend_count =", value, "attendCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountNotEqualTo(Integer value) {
            addCriterion("attend_count <>", value, "attendCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountGreaterThan(Integer value) {
            addCriterion("attend_count >", value, "attendCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("attend_count >=", value, "attendCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountLessThan(Integer value) {
            addCriterion("attend_count <", value, "attendCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountLessThanOrEqualTo(Integer value) {
            addCriterion("attend_count <=", value, "attendCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountIn(List<Integer> values) {
            addCriterion("attend_count in", values, "attendCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountNotIn(List<Integer> values) {
            addCriterion("attend_count not in", values, "attendCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountBetween(Integer value1, Integer value2) {
            addCriterion("attend_count between", value1, value2, "attendCount");
            return (Criteria) this;
        }

        public Criteria andAttendCountNotBetween(Integer value1, Integer value2) {
            addCriterion("attend_count not between", value1, value2, "attendCount");
            return (Criteria) this;
        }

        public Criteria andFansCountIsNull() {
            addCriterion("fans_count is null");
            return (Criteria) this;
        }

        public Criteria andFansCountIsNotNull() {
            addCriterion("fans_count is not null");
            return (Criteria) this;
        }

        public Criteria andFansCountEqualTo(Integer value) {
            addCriterion("fans_count =", value, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountNotEqualTo(Integer value) {
            addCriterion("fans_count <>", value, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountGreaterThan(Integer value) {
            addCriterion("fans_count >", value, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("fans_count >=", value, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountLessThan(Integer value) {
            addCriterion("fans_count <", value, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountLessThanOrEqualTo(Integer value) {
            addCriterion("fans_count <=", value, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountIn(List<Integer> values) {
            addCriterion("fans_count in", values, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountNotIn(List<Integer> values) {
            addCriterion("fans_count not in", values, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountBetween(Integer value1, Integer value2) {
            addCriterion("fans_count between", value1, value2, "fansCount");
            return (Criteria) this;
        }

        public Criteria andFansCountNotBetween(Integer value1, Integer value2) {
            addCriterion("fans_count not between", value1, value2, "fansCount");
            return (Criteria) this;
        }

        public Criteria andBrowseProductCountIsNull() {
            addCriterion("browse_product_count is null");
            return (Criteria) this;
        }

        public Criteria andBrowseProductCountIsNotNull() {
            addCriterion("browse_product_count is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseProductCountEqualTo(Integer value) {
            addCriterion("browse_product_count =", value, "browseProductCount");
            return (Criteria) this;
        }

        public Criteria andBrowseProductCountNotEqualTo(Integer value) {
            addCriterion("browse_product_count <>", value, "browseProductCount");
            return (Criteria) this;
        }

        public Criteria andBrowseProductCountGreaterThan(Integer value) {
            addCriterion("browse_product_count >", value, "browseProductCount");
            return (Criteria) this;
        }

        public Criteria andBrowseProductCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("browse_product_count >=", value, "browseProductCount");
            return (Criteria) this;
        }

        public Criteria andBrowseProductCountLessThan(Integer value) {
            addCriterion("browse_product_count <", value, "browseProductCount");
            return (Criteria) this;
        }

        public Criteria andBrowseProductCountLessThanOrEqualTo(Integer value) {
            addCriterion("browse_product_count <=", value, "browseProductCount");
            return (Criteria) this;
        }

        public Criteria andBrowseProductCountIn(List<Integer> values) {
            addCriterion("browse_product_count in", values, "browseProductCount");
            return (Criteria) this;
        }

        public Criteria andBrowseProductCountNotIn(List<Integer> values) {
            addCriterion("browse_product_count not in", values, "browseProductCount");
            return (Criteria) this;
        }

        public Criteria andBrowseProductCountBetween(Integer value1, Integer value2) {
            addCriterion("browse_product_count between", value1, value2, "browseProductCount");
            return (Criteria) this;
        }

        public Criteria andBrowseProductCountNotBetween(Integer value1, Integer value2) {
            addCriterion("browse_product_count not between", value1, value2, "browseProductCount");
            return (Criteria) this;
        }

        public Criteria andCollectProductCountIsNull() {
            addCriterion("collect_product_count is null");
            return (Criteria) this;
        }

        public Criteria andCollectProductCountIsNotNull() {
            addCriterion("collect_product_count is not null");
            return (Criteria) this;
        }

        public Criteria andCollectProductCountEqualTo(Integer value) {
            addCriterion("collect_product_count =", value, "collectProductCount");
            return (Criteria) this;
        }

        public Criteria andCollectProductCountNotEqualTo(Integer value) {
            addCriterion("collect_product_count <>", value, "collectProductCount");
            return (Criteria) this;
        }

        public Criteria andCollectProductCountGreaterThan(Integer value) {
            addCriterion("collect_product_count >", value, "collectProductCount");
            return (Criteria) this;
        }

        public Criteria andCollectProductCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_product_count >=", value, "collectProductCount");
            return (Criteria) this;
        }

        public Criteria andCollectProductCountLessThan(Integer value) {
            addCriterion("collect_product_count <", value, "collectProductCount");
            return (Criteria) this;
        }

        public Criteria andCollectProductCountLessThanOrEqualTo(Integer value) {
            addCriterion("collect_product_count <=", value, "collectProductCount");
            return (Criteria) this;
        }

        public Criteria andCollectProductCountIn(List<Integer> values) {
            addCriterion("collect_product_count in", values, "collectProductCount");
            return (Criteria) this;
        }

        public Criteria andCollectProductCountNotIn(List<Integer> values) {
            addCriterion("collect_product_count not in", values, "collectProductCount");
            return (Criteria) this;
        }

        public Criteria andCollectProductCountBetween(Integer value1, Integer value2) {
            addCriterion("collect_product_count between", value1, value2, "collectProductCount");
            return (Criteria) this;
        }

        public Criteria andCollectProductCountNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_product_count not between", value1, value2, "collectProductCount");
            return (Criteria) this;
        }

        public Criteria andRecentOrderSelfTimeIsNull() {
            addCriterion("recent_order_self_time is null");
            return (Criteria) this;
        }

        public Criteria andRecentOrderSelfTimeIsNotNull() {
            addCriterion("recent_order_self_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecentOrderSelfTimeEqualTo(Date value) {
            addCriterion("recent_order_self_time =", value, "recentOrderSelfTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderSelfTimeNotEqualTo(Date value) {
            addCriterion("recent_order_self_time <>", value, "recentOrderSelfTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderSelfTimeGreaterThan(Date value) {
            addCriterion("recent_order_self_time >", value, "recentOrderSelfTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderSelfTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("recent_order_self_time >=", value, "recentOrderSelfTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderSelfTimeLessThan(Date value) {
            addCriterion("recent_order_self_time <", value, "recentOrderSelfTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderSelfTimeLessThanOrEqualTo(Date value) {
            addCriterion("recent_order_self_time <=", value, "recentOrderSelfTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderSelfTimeIn(List<Date> values) {
            addCriterion("recent_order_self_time in", values, "recentOrderSelfTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderSelfTimeNotIn(List<Date> values) {
            addCriterion("recent_order_self_time not in", values, "recentOrderSelfTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderSelfTimeBetween(Date value1, Date value2) {
            addCriterion("recent_order_self_time between", value1, value2, "recentOrderSelfTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderSelfTimeNotBetween(Date value1, Date value2) {
            addCriterion("recent_order_self_time not between", value1, value2, "recentOrderSelfTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeIsNull() {
            addCriterion("recent_order_time is null");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeIsNotNull() {
            addCriterion("recent_order_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeEqualTo(Date value) {
            addCriterion("recent_order_time =", value, "recentOrderTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeNotEqualTo(Date value) {
            addCriterion("recent_order_time <>", value, "recentOrderTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeGreaterThan(Date value) {
            addCriterion("recent_order_time >", value, "recentOrderTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("recent_order_time >=", value, "recentOrderTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeLessThan(Date value) {
            addCriterion("recent_order_time <", value, "recentOrderTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("recent_order_time <=", value, "recentOrderTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeIn(List<Date> values) {
            addCriterion("recent_order_time in", values, "recentOrderTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeNotIn(List<Date> values) {
            addCriterion("recent_order_time not in", values, "recentOrderTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeBetween(Date value1, Date value2) {
            addCriterion("recent_order_time between", value1, value2, "recentOrderTime");
            return (Criteria) this;
        }

        public Criteria andRecentOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("recent_order_time not between", value1, value2, "recentOrderTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}