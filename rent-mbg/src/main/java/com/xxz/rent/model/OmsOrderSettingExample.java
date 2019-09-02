package com.xxz.rent.model;

import java.util.ArrayList;
import java.util.List;

public class OmsOrderSettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmsOrderSettingExample() {
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

        public Criteria andNormalOrderOvertimeIsNull() {
            addCriterion("normal_order_overtime is null");
            return (Criteria) this;
        }

        public Criteria andNormalOrderOvertimeIsNotNull() {
            addCriterion("normal_order_overtime is not null");
            return (Criteria) this;
        }

        public Criteria andNormalOrderOvertimeEqualTo(Integer value) {
            addCriterion("normal_order_overtime =", value, "normalOrderOvertime");
            return (Criteria) this;
        }

        public Criteria andNormalOrderOvertimeNotEqualTo(Integer value) {
            addCriterion("normal_order_overtime <>", value, "normalOrderOvertime");
            return (Criteria) this;
        }

        public Criteria andNormalOrderOvertimeGreaterThan(Integer value) {
            addCriterion("normal_order_overtime >", value, "normalOrderOvertime");
            return (Criteria) this;
        }

        public Criteria andNormalOrderOvertimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("normal_order_overtime >=", value, "normalOrderOvertime");
            return (Criteria) this;
        }

        public Criteria andNormalOrderOvertimeLessThan(Integer value) {
            addCriterion("normal_order_overtime <", value, "normalOrderOvertime");
            return (Criteria) this;
        }

        public Criteria andNormalOrderOvertimeLessThanOrEqualTo(Integer value) {
            addCriterion("normal_order_overtime <=", value, "normalOrderOvertime");
            return (Criteria) this;
        }

        public Criteria andNormalOrderOvertimeIn(List<Integer> values) {
            addCriterion("normal_order_overtime in", values, "normalOrderOvertime");
            return (Criteria) this;
        }

        public Criteria andNormalOrderOvertimeNotIn(List<Integer> values) {
            addCriterion("normal_order_overtime not in", values, "normalOrderOvertime");
            return (Criteria) this;
        }

        public Criteria andNormalOrderOvertimeBetween(Integer value1, Integer value2) {
            addCriterion("normal_order_overtime between", value1, value2, "normalOrderOvertime");
            return (Criteria) this;
        }

        public Criteria andNormalOrderOvertimeNotBetween(Integer value1, Integer value2) {
            addCriterion("normal_order_overtime not between", value1, value2, "normalOrderOvertime");
            return (Criteria) this;
        }

        public Criteria andPaymentIntegralIsNull() {
            addCriterion("payment_integral is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIntegralIsNotNull() {
            addCriterion("payment_integral is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentIntegralEqualTo(Integer value) {
            addCriterion("payment_integral =", value, "paymentIntegral");
            return (Criteria) this;
        }

        public Criteria andPaymentIntegralNotEqualTo(Integer value) {
            addCriterion("payment_integral <>", value, "paymentIntegral");
            return (Criteria) this;
        }

        public Criteria andPaymentIntegralGreaterThan(Integer value) {
            addCriterion("payment_integral >", value, "paymentIntegral");
            return (Criteria) this;
        }

        public Criteria andPaymentIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_integral >=", value, "paymentIntegral");
            return (Criteria) this;
        }

        public Criteria andPaymentIntegralLessThan(Integer value) {
            addCriterion("payment_integral <", value, "paymentIntegral");
            return (Criteria) this;
        }

        public Criteria andPaymentIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("payment_integral <=", value, "paymentIntegral");
            return (Criteria) this;
        }

        public Criteria andPaymentIntegralIn(List<Integer> values) {
            addCriterion("payment_integral in", values, "paymentIntegral");
            return (Criteria) this;
        }

        public Criteria andPaymentIntegralNotIn(List<Integer> values) {
            addCriterion("payment_integral not in", values, "paymentIntegral");
            return (Criteria) this;
        }

        public Criteria andPaymentIntegralBetween(Integer value1, Integer value2) {
            addCriterion("payment_integral between", value1, value2, "paymentIntegral");
            return (Criteria) this;
        }

        public Criteria andPaymentIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_integral not between", value1, value2, "paymentIntegral");
            return (Criteria) this;
        }

        public Criteria andOverdueRateIsNull() {
            addCriterion("overdue_rate is null");
            return (Criteria) this;
        }

        public Criteria andOverdueRateIsNotNull() {
            addCriterion("overdue_rate is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueRateEqualTo(Integer value) {
            addCriterion("overdue_rate =", value, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andOverdueRateNotEqualTo(Integer value) {
            addCriterion("overdue_rate <>", value, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andOverdueRateGreaterThan(Integer value) {
            addCriterion("overdue_rate >", value, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andOverdueRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("overdue_rate >=", value, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andOverdueRateLessThan(Integer value) {
            addCriterion("overdue_rate <", value, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andOverdueRateLessThanOrEqualTo(Integer value) {
            addCriterion("overdue_rate <=", value, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andOverdueRateIn(List<Integer> values) {
            addCriterion("overdue_rate in", values, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andOverdueRateNotIn(List<Integer> values) {
            addCriterion("overdue_rate not in", values, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andOverdueRateBetween(Integer value1, Integer value2) {
            addCriterion("overdue_rate between", value1, value2, "overdueRate");
            return (Criteria) this;
        }

        public Criteria andOverdueRateNotBetween(Integer value1, Integer value2) {
            addCriterion("overdue_rate not between", value1, value2, "overdueRate");
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