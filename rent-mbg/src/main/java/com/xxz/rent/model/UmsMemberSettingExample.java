package com.xxz.rent.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UmsMemberSettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UmsMemberSettingExample() {
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

        public Criteria andRegistIntegralIsNull() {
            addCriterion("regist_integral is null");
            return (Criteria) this;
        }

        public Criteria andRegistIntegralIsNotNull() {
            addCriterion("regist_integral is not null");
            return (Criteria) this;
        }

        public Criteria andRegistIntegralEqualTo(Integer value) {
            addCriterion("regist_integral =", value, "registIntegral");
            return (Criteria) this;
        }

        public Criteria andRegistIntegralNotEqualTo(Integer value) {
            addCriterion("regist_integral <>", value, "registIntegral");
            return (Criteria) this;
        }

        public Criteria andRegistIntegralGreaterThan(Integer value) {
            addCriterion("regist_integral >", value, "registIntegral");
            return (Criteria) this;
        }

        public Criteria andRegistIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("regist_integral >=", value, "registIntegral");
            return (Criteria) this;
        }

        public Criteria andRegistIntegralLessThan(Integer value) {
            addCriterion("regist_integral <", value, "registIntegral");
            return (Criteria) this;
        }

        public Criteria andRegistIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("regist_integral <=", value, "registIntegral");
            return (Criteria) this;
        }

        public Criteria andRegistIntegralIn(List<Integer> values) {
            addCriterion("regist_integral in", values, "registIntegral");
            return (Criteria) this;
        }

        public Criteria andRegistIntegralNotIn(List<Integer> values) {
            addCriterion("regist_integral not in", values, "registIntegral");
            return (Criteria) this;
        }

        public Criteria andRegistIntegralBetween(Integer value1, Integer value2) {
            addCriterion("regist_integral between", value1, value2, "registIntegral");
            return (Criteria) this;
        }

        public Criteria andRegistIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("regist_integral not between", value1, value2, "registIntegral");
            return (Criteria) this;
        }

        public Criteria andMemberFreeAmountIsNull() {
            addCriterion("member_free_amount is null");
            return (Criteria) this;
        }

        public Criteria andMemberFreeAmountIsNotNull() {
            addCriterion("member_free_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMemberFreeAmountEqualTo(BigDecimal value) {
            addCriterion("member_free_amount =", value, "memberFreeAmount");
            return (Criteria) this;
        }

        public Criteria andMemberFreeAmountNotEqualTo(BigDecimal value) {
            addCriterion("member_free_amount <>", value, "memberFreeAmount");
            return (Criteria) this;
        }

        public Criteria andMemberFreeAmountGreaterThan(BigDecimal value) {
            addCriterion("member_free_amount >", value, "memberFreeAmount");
            return (Criteria) this;
        }

        public Criteria andMemberFreeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("member_free_amount >=", value, "memberFreeAmount");
            return (Criteria) this;
        }

        public Criteria andMemberFreeAmountLessThan(BigDecimal value) {
            addCriterion("member_free_amount <", value, "memberFreeAmount");
            return (Criteria) this;
        }

        public Criteria andMemberFreeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("member_free_amount <=", value, "memberFreeAmount");
            return (Criteria) this;
        }

        public Criteria andMemberFreeAmountIn(List<BigDecimal> values) {
            addCriterion("member_free_amount in", values, "memberFreeAmount");
            return (Criteria) this;
        }

        public Criteria andMemberFreeAmountNotIn(List<BigDecimal> values) {
            addCriterion("member_free_amount not in", values, "memberFreeAmount");
            return (Criteria) this;
        }

        public Criteria andMemberFreeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("member_free_amount between", value1, value2, "memberFreeAmount");
            return (Criteria) this;
        }

        public Criteria andMemberFreeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("member_free_amount not between", value1, value2, "memberFreeAmount");
            return (Criteria) this;
        }

        public Criteria andRealinformAmountIsNull() {
            addCriterion("realinform_amount is null");
            return (Criteria) this;
        }

        public Criteria andRealinformAmountIsNotNull() {
            addCriterion("realinform_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRealinformAmountEqualTo(BigDecimal value) {
            addCriterion("realinform_amount =", value, "realinformAmount");
            return (Criteria) this;
        }

        public Criteria andRealinformAmountNotEqualTo(BigDecimal value) {
            addCriterion("realinform_amount <>", value, "realinformAmount");
            return (Criteria) this;
        }

        public Criteria andRealinformAmountGreaterThan(BigDecimal value) {
            addCriterion("realinform_amount >", value, "realinformAmount");
            return (Criteria) this;
        }

        public Criteria andRealinformAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("realinform_amount >=", value, "realinformAmount");
            return (Criteria) this;
        }

        public Criteria andRealinformAmountLessThan(BigDecimal value) {
            addCriterion("realinform_amount <", value, "realinformAmount");
            return (Criteria) this;
        }

        public Criteria andRealinformAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("realinform_amount <=", value, "realinformAmount");
            return (Criteria) this;
        }

        public Criteria andRealinformAmountIn(List<BigDecimal> values) {
            addCriterion("realinform_amount in", values, "realinformAmount");
            return (Criteria) this;
        }

        public Criteria andRealinformAmountNotIn(List<BigDecimal> values) {
            addCriterion("realinform_amount not in", values, "realinformAmount");
            return (Criteria) this;
        }

        public Criteria andRealinformAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("realinform_amount between", value1, value2, "realinformAmount");
            return (Criteria) this;
        }

        public Criteria andRealinformAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("realinform_amount not between", value1, value2, "realinformAmount");
            return (Criteria) this;
        }

        public Criteria andBaseinfoAmountIsNull() {
            addCriterion("baseinfo_amount is null");
            return (Criteria) this;
        }

        public Criteria andBaseinfoAmountIsNotNull() {
            addCriterion("baseinfo_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBaseinfoAmountEqualTo(BigDecimal value) {
            addCriterion("baseinfo_amount =", value, "baseinfoAmount");
            return (Criteria) this;
        }

        public Criteria andBaseinfoAmountNotEqualTo(BigDecimal value) {
            addCriterion("baseinfo_amount <>", value, "baseinfoAmount");
            return (Criteria) this;
        }

        public Criteria andBaseinfoAmountGreaterThan(BigDecimal value) {
            addCriterion("baseinfo_amount >", value, "baseinfoAmount");
            return (Criteria) this;
        }

        public Criteria andBaseinfoAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("baseinfo_amount >=", value, "baseinfoAmount");
            return (Criteria) this;
        }

        public Criteria andBaseinfoAmountLessThan(BigDecimal value) {
            addCriterion("baseinfo_amount <", value, "baseinfoAmount");
            return (Criteria) this;
        }

        public Criteria andBaseinfoAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("baseinfo_amount <=", value, "baseinfoAmount");
            return (Criteria) this;
        }

        public Criteria andBaseinfoAmountIn(List<BigDecimal> values) {
            addCriterion("baseinfo_amount in", values, "baseinfoAmount");
            return (Criteria) this;
        }

        public Criteria andBaseinfoAmountNotIn(List<BigDecimal> values) {
            addCriterion("baseinfo_amount not in", values, "baseinfoAmount");
            return (Criteria) this;
        }

        public Criteria andBaseinfoAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("baseinfo_amount between", value1, value2, "baseinfoAmount");
            return (Criteria) this;
        }

        public Criteria andBaseinfoAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("baseinfo_amount not between", value1, value2, "baseinfoAmount");
            return (Criteria) this;
        }

        public Criteria andKinsfolkAmountIsNull() {
            addCriterion("kinsfolk_amount is null");
            return (Criteria) this;
        }

        public Criteria andKinsfolkAmountIsNotNull() {
            addCriterion("kinsfolk_amount is not null");
            return (Criteria) this;
        }

        public Criteria andKinsfolkAmountEqualTo(BigDecimal value) {
            addCriterion("kinsfolk_amount =", value, "kinsfolkAmount");
            return (Criteria) this;
        }

        public Criteria andKinsfolkAmountNotEqualTo(BigDecimal value) {
            addCriterion("kinsfolk_amount <>", value, "kinsfolkAmount");
            return (Criteria) this;
        }

        public Criteria andKinsfolkAmountGreaterThan(BigDecimal value) {
            addCriterion("kinsfolk_amount >", value, "kinsfolkAmount");
            return (Criteria) this;
        }

        public Criteria andKinsfolkAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kinsfolk_amount >=", value, "kinsfolkAmount");
            return (Criteria) this;
        }

        public Criteria andKinsfolkAmountLessThan(BigDecimal value) {
            addCriterion("kinsfolk_amount <", value, "kinsfolkAmount");
            return (Criteria) this;
        }

        public Criteria andKinsfolkAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kinsfolk_amount <=", value, "kinsfolkAmount");
            return (Criteria) this;
        }

        public Criteria andKinsfolkAmountIn(List<BigDecimal> values) {
            addCriterion("kinsfolk_amount in", values, "kinsfolkAmount");
            return (Criteria) this;
        }

        public Criteria andKinsfolkAmountNotIn(List<BigDecimal> values) {
            addCriterion("kinsfolk_amount not in", values, "kinsfolkAmount");
            return (Criteria) this;
        }

        public Criteria andKinsfolkAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kinsfolk_amount between", value1, value2, "kinsfolkAmount");
            return (Criteria) this;
        }

        public Criteria andKinsfolkAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kinsfolk_amount not between", value1, value2, "kinsfolkAmount");
            return (Criteria) this;
        }

        public Criteria andLinkAmountIsNull() {
            addCriterion("link_amount is null");
            return (Criteria) this;
        }

        public Criteria andLinkAmountIsNotNull() {
            addCriterion("link_amount is not null");
            return (Criteria) this;
        }

        public Criteria andLinkAmountEqualTo(BigDecimal value) {
            addCriterion("link_amount =", value, "linkAmount");
            return (Criteria) this;
        }

        public Criteria andLinkAmountNotEqualTo(BigDecimal value) {
            addCriterion("link_amount <>", value, "linkAmount");
            return (Criteria) this;
        }

        public Criteria andLinkAmountGreaterThan(BigDecimal value) {
            addCriterion("link_amount >", value, "linkAmount");
            return (Criteria) this;
        }

        public Criteria andLinkAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("link_amount >=", value, "linkAmount");
            return (Criteria) this;
        }

        public Criteria andLinkAmountLessThan(BigDecimal value) {
            addCriterion("link_amount <", value, "linkAmount");
            return (Criteria) this;
        }

        public Criteria andLinkAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("link_amount <=", value, "linkAmount");
            return (Criteria) this;
        }

        public Criteria andLinkAmountIn(List<BigDecimal> values) {
            addCriterion("link_amount in", values, "linkAmount");
            return (Criteria) this;
        }

        public Criteria andLinkAmountNotIn(List<BigDecimal> values) {
            addCriterion("link_amount not in", values, "linkAmount");
            return (Criteria) this;
        }

        public Criteria andLinkAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("link_amount between", value1, value2, "linkAmount");
            return (Criteria) this;
        }

        public Criteria andLinkAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("link_amount not between", value1, value2, "linkAmount");
            return (Criteria) this;
        }

        public Criteria andTaobaoAmountIsNull() {
            addCriterion("taobao_amount is null");
            return (Criteria) this;
        }

        public Criteria andTaobaoAmountIsNotNull() {
            addCriterion("taobao_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTaobaoAmountEqualTo(BigDecimal value) {
            addCriterion("taobao_amount =", value, "taobaoAmount");
            return (Criteria) this;
        }

        public Criteria andTaobaoAmountNotEqualTo(BigDecimal value) {
            addCriterion("taobao_amount <>", value, "taobaoAmount");
            return (Criteria) this;
        }

        public Criteria andTaobaoAmountGreaterThan(BigDecimal value) {
            addCriterion("taobao_amount >", value, "taobaoAmount");
            return (Criteria) this;
        }

        public Criteria andTaobaoAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("taobao_amount >=", value, "taobaoAmount");
            return (Criteria) this;
        }

        public Criteria andTaobaoAmountLessThan(BigDecimal value) {
            addCriterion("taobao_amount <", value, "taobaoAmount");
            return (Criteria) this;
        }

        public Criteria andTaobaoAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("taobao_amount <=", value, "taobaoAmount");
            return (Criteria) this;
        }

        public Criteria andTaobaoAmountIn(List<BigDecimal> values) {
            addCriterion("taobao_amount in", values, "taobaoAmount");
            return (Criteria) this;
        }

        public Criteria andTaobaoAmountNotIn(List<BigDecimal> values) {
            addCriterion("taobao_amount not in", values, "taobaoAmount");
            return (Criteria) this;
        }

        public Criteria andTaobaoAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("taobao_amount between", value1, value2, "taobaoAmount");
            return (Criteria) this;
        }

        public Criteria andTaobaoAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("taobao_amount not between", value1, value2, "taobaoAmount");
            return (Criteria) this;
        }

        public Criteria andMobileAmountIsNull() {
            addCriterion("mobile_amount is null");
            return (Criteria) this;
        }

        public Criteria andMobileAmountIsNotNull() {
            addCriterion("mobile_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMobileAmountEqualTo(BigDecimal value) {
            addCriterion("mobile_amount =", value, "mobileAmount");
            return (Criteria) this;
        }

        public Criteria andMobileAmountNotEqualTo(BigDecimal value) {
            addCriterion("mobile_amount <>", value, "mobileAmount");
            return (Criteria) this;
        }

        public Criteria andMobileAmountGreaterThan(BigDecimal value) {
            addCriterion("mobile_amount >", value, "mobileAmount");
            return (Criteria) this;
        }

        public Criteria andMobileAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mobile_amount >=", value, "mobileAmount");
            return (Criteria) this;
        }

        public Criteria andMobileAmountLessThan(BigDecimal value) {
            addCriterion("mobile_amount <", value, "mobileAmount");
            return (Criteria) this;
        }

        public Criteria andMobileAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mobile_amount <=", value, "mobileAmount");
            return (Criteria) this;
        }

        public Criteria andMobileAmountIn(List<BigDecimal> values) {
            addCriterion("mobile_amount in", values, "mobileAmount");
            return (Criteria) this;
        }

        public Criteria andMobileAmountNotIn(List<BigDecimal> values) {
            addCriterion("mobile_amount not in", values, "mobileAmount");
            return (Criteria) this;
        }

        public Criteria andMobileAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mobile_amount between", value1, value2, "mobileAmount");
            return (Criteria) this;
        }

        public Criteria andMobileAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mobile_amount not between", value1, value2, "mobileAmount");
            return (Criteria) this;
        }

        public Criteria andStudyAmountIsNull() {
            addCriterion("study_amount is null");
            return (Criteria) this;
        }

        public Criteria andStudyAmountIsNotNull() {
            addCriterion("study_amount is not null");
            return (Criteria) this;
        }

        public Criteria andStudyAmountEqualTo(BigDecimal value) {
            addCriterion("study_amount =", value, "studyAmount");
            return (Criteria) this;
        }

        public Criteria andStudyAmountNotEqualTo(BigDecimal value) {
            addCriterion("study_amount <>", value, "studyAmount");
            return (Criteria) this;
        }

        public Criteria andStudyAmountGreaterThan(BigDecimal value) {
            addCriterion("study_amount >", value, "studyAmount");
            return (Criteria) this;
        }

        public Criteria andStudyAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("study_amount >=", value, "studyAmount");
            return (Criteria) this;
        }

        public Criteria andStudyAmountLessThan(BigDecimal value) {
            addCriterion("study_amount <", value, "studyAmount");
            return (Criteria) this;
        }

        public Criteria andStudyAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("study_amount <=", value, "studyAmount");
            return (Criteria) this;
        }

        public Criteria andStudyAmountIn(List<BigDecimal> values) {
            addCriterion("study_amount in", values, "studyAmount");
            return (Criteria) this;
        }

        public Criteria andStudyAmountNotIn(List<BigDecimal> values) {
            addCriterion("study_amount not in", values, "studyAmount");
            return (Criteria) this;
        }

        public Criteria andStudyAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("study_amount between", value1, value2, "studyAmount");
            return (Criteria) this;
        }

        public Criteria andStudyAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("study_amount not between", value1, value2, "studyAmount");
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