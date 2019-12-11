package com.xxz.rent.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OmsOrderPaymentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmsOrderPaymentExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIsNull() {
            addCriterion("pay_money is null");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIsNotNull() {
            addCriterion("pay_money is not null");
            return (Criteria) this;
        }

        public Criteria andPayMoneyEqualTo(BigDecimal value) {
            addCriterion("pay_money =", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotEqualTo(BigDecimal value) {
            addCriterion("pay_money <>", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyGreaterThan(BigDecimal value) {
            addCriterion("pay_money >", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_money >=", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLessThan(BigDecimal value) {
            addCriterion("pay_money <", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_money <=", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIn(List<BigDecimal> values) {
            addCriterion("pay_money in", values, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotIn(List<BigDecimal> values) {
            addCriterion("pay_money not in", values, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_money between", value1, value2, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_money not between", value1, value2, "payMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyIsNull() {
            addCriterion("real_pay_money is null");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyIsNotNull() {
            addCriterion("real_pay_money is not null");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyEqualTo(BigDecimal value) {
            addCriterion("real_pay_money =", value, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyNotEqualTo(BigDecimal value) {
            addCriterion("real_pay_money <>", value, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyGreaterThan(BigDecimal value) {
            addCriterion("real_pay_money >", value, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_pay_money >=", value, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyLessThan(BigDecimal value) {
            addCriterion("real_pay_money <", value, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_pay_money <=", value, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyIn(List<BigDecimal> values) {
            addCriterion("real_pay_money in", values, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyNotIn(List<BigDecimal> values) {
            addCriterion("real_pay_money not in", values, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_pay_money between", value1, value2, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andRealPayMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_pay_money not between", value1, value2, "realPayMoney");
            return (Criteria) this;
        }

        public Criteria andBaseMoneyIsNull() {
            addCriterion("base_money is null");
            return (Criteria) this;
        }

        public Criteria andBaseMoneyIsNotNull() {
            addCriterion("base_money is not null");
            return (Criteria) this;
        }

        public Criteria andBaseMoneyEqualTo(BigDecimal value) {
            addCriterion("base_money =", value, "baseMoney");
            return (Criteria) this;
        }

        public Criteria andBaseMoneyNotEqualTo(BigDecimal value) {
            addCriterion("base_money <>", value, "baseMoney");
            return (Criteria) this;
        }

        public Criteria andBaseMoneyGreaterThan(BigDecimal value) {
            addCriterion("base_money >", value, "baseMoney");
            return (Criteria) this;
        }

        public Criteria andBaseMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("base_money >=", value, "baseMoney");
            return (Criteria) this;
        }

        public Criteria andBaseMoneyLessThan(BigDecimal value) {
            addCriterion("base_money <", value, "baseMoney");
            return (Criteria) this;
        }

        public Criteria andBaseMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("base_money <=", value, "baseMoney");
            return (Criteria) this;
        }

        public Criteria andBaseMoneyIn(List<BigDecimal> values) {
            addCriterion("base_money in", values, "baseMoney");
            return (Criteria) this;
        }

        public Criteria andBaseMoneyNotIn(List<BigDecimal> values) {
            addCriterion("base_money not in", values, "baseMoney");
            return (Criteria) this;
        }

        public Criteria andBaseMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("base_money between", value1, value2, "baseMoney");
            return (Criteria) this;
        }

        public Criteria andBaseMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("base_money not between", value1, value2, "baseMoney");
            return (Criteria) this;
        }

        public Criteria andPreferentialMoneyIsNull() {
            addCriterion("preferential_money is null");
            return (Criteria) this;
        }

        public Criteria andPreferentialMoneyIsNotNull() {
            addCriterion("preferential_money is not null");
            return (Criteria) this;
        }

        public Criteria andPreferentialMoneyEqualTo(BigDecimal value) {
            addCriterion("preferential_money =", value, "preferentialMoney");
            return (Criteria) this;
        }

        public Criteria andPreferentialMoneyNotEqualTo(BigDecimal value) {
            addCriterion("preferential_money <>", value, "preferentialMoney");
            return (Criteria) this;
        }

        public Criteria andPreferentialMoneyGreaterThan(BigDecimal value) {
            addCriterion("preferential_money >", value, "preferentialMoney");
            return (Criteria) this;
        }

        public Criteria andPreferentialMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("preferential_money >=", value, "preferentialMoney");
            return (Criteria) this;
        }

        public Criteria andPreferentialMoneyLessThan(BigDecimal value) {
            addCriterion("preferential_money <", value, "preferentialMoney");
            return (Criteria) this;
        }

        public Criteria andPreferentialMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("preferential_money <=", value, "preferentialMoney");
            return (Criteria) this;
        }

        public Criteria andPreferentialMoneyIn(List<BigDecimal> values) {
            addCriterion("preferential_money in", values, "preferentialMoney");
            return (Criteria) this;
        }

        public Criteria andPreferentialMoneyNotIn(List<BigDecimal> values) {
            addCriterion("preferential_money not in", values, "preferentialMoney");
            return (Criteria) this;
        }

        public Criteria andPreferentialMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("preferential_money between", value1, value2, "preferentialMoney");
            return (Criteria) this;
        }

        public Criteria andPreferentialMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("preferential_money not between", value1, value2, "preferentialMoney");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterionForJDBCDate("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterionForJDBCDate("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterionForJDBCDate("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andRealPayTimeIsNull() {
            addCriterion("real_pay_time is null");
            return (Criteria) this;
        }

        public Criteria andRealPayTimeIsNotNull() {
            addCriterion("real_pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andRealPayTimeEqualTo(Date value) {
            addCriterion("real_pay_time =", value, "realPayTime");
            return (Criteria) this;
        }

        public Criteria andRealPayTimeNotEqualTo(Date value) {
            addCriterion("real_pay_time <>", value, "realPayTime");
            return (Criteria) this;
        }

        public Criteria andRealPayTimeGreaterThan(Date value) {
            addCriterion("real_pay_time >", value, "realPayTime");
            return (Criteria) this;
        }

        public Criteria andRealPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("real_pay_time >=", value, "realPayTime");
            return (Criteria) this;
        }

        public Criteria andRealPayTimeLessThan(Date value) {
            addCriterion("real_pay_time <", value, "realPayTime");
            return (Criteria) this;
        }

        public Criteria andRealPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("real_pay_time <=", value, "realPayTime");
            return (Criteria) this;
        }

        public Criteria andRealPayTimeIn(List<Date> values) {
            addCriterion("real_pay_time in", values, "realPayTime");
            return (Criteria) this;
        }

        public Criteria andRealPayTimeNotIn(List<Date> values) {
            addCriterion("real_pay_time not in", values, "realPayTime");
            return (Criteria) this;
        }

        public Criteria andRealPayTimeBetween(Date value1, Date value2) {
            addCriterion("real_pay_time between", value1, value2, "realPayTime");
            return (Criteria) this;
        }

        public Criteria andRealPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("real_pay_time not between", value1, value2, "realPayTime");
            return (Criteria) this;
        }

        public Criteria andIdexIsNull() {
            addCriterion("idex is null");
            return (Criteria) this;
        }

        public Criteria andIdexIsNotNull() {
            addCriterion("idex is not null");
            return (Criteria) this;
        }

        public Criteria andIdexEqualTo(Integer value) {
            addCriterion("idex =", value, "idex");
            return (Criteria) this;
        }

        public Criteria andIdexNotEqualTo(Integer value) {
            addCriterion("idex <>", value, "idex");
            return (Criteria) this;
        }

        public Criteria andIdexGreaterThan(Integer value) {
            addCriterion("idex >", value, "idex");
            return (Criteria) this;
        }

        public Criteria andIdexGreaterThanOrEqualTo(Integer value) {
            addCriterion("idex >=", value, "idex");
            return (Criteria) this;
        }

        public Criteria andIdexLessThan(Integer value) {
            addCriterion("idex <", value, "idex");
            return (Criteria) this;
        }

        public Criteria andIdexLessThanOrEqualTo(Integer value) {
            addCriterion("idex <=", value, "idex");
            return (Criteria) this;
        }

        public Criteria andIdexIn(List<Integer> values) {
            addCriterion("idex in", values, "idex");
            return (Criteria) this;
        }

        public Criteria andIdexNotIn(List<Integer> values) {
            addCriterion("idex not in", values, "idex");
            return (Criteria) this;
        }

        public Criteria andIdexBetween(Integer value1, Integer value2) {
            addCriterion("idex between", value1, value2, "idex");
            return (Criteria) this;
        }

        public Criteria andIdexNotBetween(Integer value1, Integer value2) {
            addCriterion("idex not between", value1, value2, "idex");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyIsNull() {
            addCriterion("overdue_money is null");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyIsNotNull() {
            addCriterion("overdue_money is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyEqualTo(BigDecimal value) {
            addCriterion("overdue_money =", value, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyNotEqualTo(BigDecimal value) {
            addCriterion("overdue_money <>", value, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyGreaterThan(BigDecimal value) {
            addCriterion("overdue_money >", value, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("overdue_money >=", value, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyLessThan(BigDecimal value) {
            addCriterion("overdue_money <", value, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("overdue_money <=", value, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyIn(List<BigDecimal> values) {
            addCriterion("overdue_money in", values, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyNotIn(List<BigDecimal> values) {
            addCriterion("overdue_money not in", values, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overdue_money between", value1, value2, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overdue_money not between", value1, value2, "overdueMoney");
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